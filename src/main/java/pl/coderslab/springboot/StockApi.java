package pl.coderslab.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.repository.StocksRepository;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class StockApi {




    public Stocks getStock(String stockName) throws IOException {
/*        Stocks dto = null;
        Stock stock = YahooFinance.get(stockName);
        dto = new Stocks(stock.getName(), stock.getQuote().getPrice(), stock.getQuote().getChange(),
                stock.getCurrency(), stock.getQuote().getBid());
*/
        return getStock("null");
    }
    public Map<String, Stock> getStock(String[] stockNames) throws IOException {
        Map<String, Stock> stock = YahooFinance.get(stockNames);
        return stock;
    }

    public void getHistory(String stockName, int day, String searchType) throws IOException {
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.DATE, Integer.valueOf("-" + day));

        Stock stock = YahooFinance.get(stockName);
        List<HistoricalQuote> history = stock.getHistory(from, to, getInterval(searchType));
        for (HistoricalQuote quote : history) {
            System.out.println("====================================");
            System.out.println("symobol : " + quote.getSymbol());
            System.out.println("date : " + convertDate(quote.getDate()));
            System.out.println("High Price  : " + quote.getHigh());
            System.out.println("Low Price : " + quote.getLow());
            System.out.println("Closed price : " + quote.getClose());
            System.out.println("=========================================");
        }

    }
    private String convertDate(Calendar cal) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = format.format(cal.getTime());
        return formatDate;
    }

    private Interval getInterval(String searchType) {
       Interval interval = null;
        if ("MONTHLY".equals(searchType.toUpperCase())) {
            interval = Interval.MONTHLY;
        } else if ("WEEKLY".equals(searchType.toUpperCase())) {
            interval = Interval.WEEKLY;
        } else if ("DAILY".equals(searchType.toUpperCase())) {
            interval = Interval.DAILY;
        }
        return interval;
    }
    public void getHistory1(String stockName) throws IOException {
/*       Calendar from = Calendar.getInstance();
      Calendar to = Calendar.getInstance();
       from.add(Calendar.YEAR, Integer.valueOf("-" + year));*/

        Stock stock = YahooFinance.get(stockName);
        List<HistoricalQuote> history = stock.getHistory();

        for (HistoricalQuote quote : history) {
            System.out.println("====================================");
            System.out.println("symobol : " + quote.getSymbol());
     /*       System.out.println("date : " + convertDate(quote.getDate()));
            System.out.println("High Price  : " + quote.getHigh());
            System.out.println("Low Price : " + quote.getLow());
            System.out.println("Closed price : " + quote.getClose());
            System.out.println("=========================================");
*/
        }

    }

    public static void main(String[] args) throws IOException {



        StockApi yahooStockAPI = new StockApi();
        Stock stock = YahooFinance.get("INTC");


        System.out.println(stock.getName());
        System.out.println(stock.getQuote().getPrice());
        System.out.println(stock.getCurrency());
        System.out.println(stock.getDividend().getAnnualYield());
        System.out.println(stock.getDividend().getPayDate().getTime());
        System.out.println(stock.getQuote().getChangeInPercent());
        System.out.println(stock.getDividend().getAnnualYieldPercent());
        String name = stock.getName();
        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();


       // System.out.println(stock.;
     //  yahooStockAPI.getHistory("INTC", 3, "Daily");



        }
    private final String INSERT_SQL = "INSERT INTO stocks(name, price, change) values(?,?,?)";
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Stocks create(final Stocks stocks) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", stocks.getName())
                .addValue("price", stocks.getPrice())
                .addValue("change", stocks.getChange());
        namedParameterJdbcTemplate.update(INSERT_SQL, parameters);
        System.out.println("=======" + stocks);
        return stocks;
    }


}




