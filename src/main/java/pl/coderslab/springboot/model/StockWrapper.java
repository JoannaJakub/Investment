package pl.coderslab.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import yahoofinance.Stock;

import java.time.LocalDateTime;

@Getter
@With
@AllArgsConstructor
public class StockWrapper {

    private final LocalDateTime lastAccess;
    private final yahoofinance.Stock stock;

    public StockWrapper(final Stock stock){
        this.stock = stock;
        lastAccess=LocalDateTime.now();
    }
}
