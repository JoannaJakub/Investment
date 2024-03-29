package pl.coderslab.springboot;


import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

public class StockApi {
 public static void main(String[] args) throws IOException {
     Stock stock = YahooFinance.get("INTC");

     BigDecimal price = stock.getQuote().getPrice();
     BigDecimal change = stock.getQuote().getChangeInPercent();
     BigDecimal peg = stock.getStats().getPeg();
     BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
 }
}




