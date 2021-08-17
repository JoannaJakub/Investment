package pl.coderslab.springboot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.coderslab.springboot.model.StockWrapper;
import pl.coderslab.springboot.service.StocksService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class StocksServiceTest {

    @Autowired
    private StocksService stockService;

    @Test
    void invoke() throws IOException {
        final StockWrapper stock = stockService.findStock("UU.L");
        System.out.println(stock.getStock());

        final BigDecimal price = stockService.findPrice(stock);
        System.out.println(price);

        final BigDecimal change = stockService.findLastChangePercent(stock);
        System.out.println(change);

        final BigDecimal mean200DayPercent = stockService.findChangeFrom200MeanPercent(stock);
        System.out.println(mean200DayPercent);
    }

    @Test
    void multiple() throws IOException, InterruptedException {
        final List<StockWrapper> stocks = stockService.findStocks(Arrays.asList("GOOG", "AMZN"));
        findPrices(stocks);

        Thread.sleep(16000);
        final StockWrapper aa = stockService.findStock("AA.W");
        stocks.add(aa);
        System.out.println(stockService.findPrice(aa));
        findPrices(stocks);
    }

    private void findPrices(List<StockWrapper> stocks) {
        stocks.forEach(stock -> {
            try {
                System.out.println(stockService.findPrice(stock));
            } catch (IOException e) {
                //Ignore
            }

        });
    }
}