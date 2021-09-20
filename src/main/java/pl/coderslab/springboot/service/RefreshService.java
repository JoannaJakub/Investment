package pl.coderslab.springboot.service;


import org.springframework.stereotype.Service;
import pl.coderslab.springboot.model.StockWrapper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class RefreshService {

    private final Map<StockWrapper, Boolean> stocksToRefersh;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final Duration refreshPeriod = Duration.ofSeconds(15);

    public RefreshService() {
        stocksToRefersh = new HashMap<>();
        setRefreshEvery15Minutes();
    }

    public boolean shouldRefresh(final StockWrapper stock) {
        if (!stocksToRefersh.containsKey(stock)) {
            stocksToRefersh.put(stock, false);
            return true;
        }
        return  stocksToRefersh.get(stock);
    }

    private void setRefreshEvery15Minutes() {
        scheduler.scheduleAtFixedRate(() ->
                stocksToRefersh.forEach((stock, value) -> {
                            if (stock.getLastAccess().isBefore(LocalDateTime.now().minus(refreshPeriod))) {
//                                System.out.println("Setting should refresh " + stock.getStock().getSymbol());
                                stocksToRefersh.remove(stock);
                                stocksToRefersh.put(stock.withLastAccess(LocalDateTime.now()), true);

                            }
                        }
                ), 0, 15, SECONDS);
    }
}
