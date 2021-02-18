package pl.coderslab.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.service.CryptocurrencyService;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/cryptocurrency")
public class CryptocurrencyController {

    @Autowired
    private CryptocurrencyService cryptocurrencyService;

    @GetMapping("/list")
    public Iterable<Cryptocurrencies> list() {
        return cryptocurrencyService.list();
    }

    @GetMapping(path = "map", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getMap(
            @RequestParam(required = false, name = "listing_status") String listingStatus,
            @RequestParam(required = false) Long start,
            @RequestParam(required = false) Long limit,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String symbol,
            @RequestParam(required = false) String aux) {
        return this.cryptocurrencyService.getMap(listingStatus, start, limit, sort, symbol, aux);
    }

    @GetMapping(path = "info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getInfo(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String slug,
            @RequestParam(required = false) String symbol,
            @RequestParam(required = false) String aux) {
        return this.cryptocurrencyService.getInfo(id, slug, symbol, aux);
    }

    @GetMapping(path = "listings/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getListingsLatest(
            @RequestParam(required = false) Long start,
            @RequestParam(required = false) Long limit,
            @RequestParam(required = false, name = "price_min") Double priceMin,
            @RequestParam(required = false, name = "price_max") Double priceMax,
            @RequestParam(required = false, name = "market_cap_min") Double marketCapMin,
            @RequestParam(required = false, name = "market_cap_max") Double marketCapMax,
            @RequestParam(required = false, name = "volume_24h_min") Double volume24hMin,
            @RequestParam(required = false, name = "volume_24h_max") Double volume24hMax,
            @RequestParam(required = false, name = "circulating_supply_min") Double circulatingSupplyMin,
            @RequestParam(required = false, name = "circulating_supply_max") Double circulatingSupplyMax,
            @RequestParam(required = false, name = "percent_change_24h_min") Double percentChange24hMin,
            @RequestParam(required = false, name = "percent_change_24h_max") Double percentChange24hMax,
            @RequestParam(required = false) String convert,
            @RequestParam(required = false, name = "convert_id") String convertId,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, name = "sort_dir") String sortDir,
            @RequestParam(required = false, name = "cryptocurrency_type") String cryptocurrencyType,
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) String aux) {
        return this.cryptocurrencyService.getListingsLatest(
                start, limit, priceMin, priceMax, marketCapMin, marketCapMax,
                volume24hMin, volume24hMax, circulatingSupplyMin, circulatingSupplyMax,
                percentChange24hMin, percentChange24hMax, convert, convertId,
                sort, sortDir, cryptocurrencyType, tag, aux);
    }

/*    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;*/


/*    public Cryptocurrencies saveToSql() throws SQLException {

        List<Cryptocurrencies> cryptoList = cryptocurrencyRepository.findAll();
        try {
            Connection conn = (Connection) DriverManager.getDrivers();
            Statement stmt = conn.createStatement();
            Map<String, Object> params = new HashMap<String, Object>();
            String sqlQ = "Insert into cryptocurrencies(start, limit, priceMin, priceMax, marketCapMin, marketCapMax, volume24hMin, volume24hMax, circulatingSupplyMin, circulatingSupplyMax, percentChange24hMin, percentChange24hMax, convert,  convertId, sort, sortDir, cryptocurrencyType, tag, aux) values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)";


            JOptionPane.showMessageDialog(null, "Saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return saveToSql();

    }*/
}
