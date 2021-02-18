package pl.coderslab.springboot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Service
public class CryptocurrencyService extends CoinMarketCapService {


    private CryptocurrencyRepository cryptocurrencyRepository;

    public CryptocurrencyService(CryptocurrencyRepository userRepository) {
        this.cryptocurrencyRepository = userRepository;
    }

    public Iterable<Cryptocurrencies> list() {
        return cryptocurrencyRepository.findAll();
    }

    public Iterable<Cryptocurrencies> save(List<Cryptocurrencies> Cryptocurrencies) {
        return cryptocurrencyRepository.saveAll(Cryptocurrencies);
    }

    @Value("${pl.coderslab.cmc.api.v1.cryptocurrency.map-endpoint:/v1/cryptocurrency/map}")
    private String CRYPTOCURRENCY_MAP_ENDPOINT;


    @Value("${com.rantcrypto.cmc.api.v1.cryptocurrency.info-endpoint:/v1/cryptocurrency/info}")
    private String CRYPTOCURRENCY_INFO_ENDPOINT;

    @Value("${com.rantcrypto.cmc.api.v1.cryptocurrency.info-endpoint.cache-time:-1}")
    private Long CRYPTOCURRENCY_INFO_ENDPOINT_CACHE_TIME;

    @Value("${com.rantcrypto.cmc.api.v1.cryptocurrency.listings-latest-endpoint:/v1/cryptocurrency/listings/latest}")
    private String CRYPTOCURRENCY_LISTINGS_LATEST_ENDPOINT;

    public ResponseEntity<Object> getMap(String listingStatus, Long start, Long limit, String sort, String symbol, String aux) {
        HashMap<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("listing_status", listingStatus);
        paramMap.put("start", (start != null ? Long.toString(start) : null));
        paramMap.put("limit", (limit != null ? Long.toString(limit) : null));
        paramMap.put("sort", sort);
        paramMap.put("symbol", symbol);
        paramMap.put("aux", aux);

        return super.getResponseFromEndpoint(CRYPTOCURRENCY_MAP_ENDPOINT, paramMap);
    }

    public ResponseEntity<Object> getInfo(String id, String slug, String symbol, String aux) {
        HashMap<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("id", id);
        paramMap.put("slug", slug);
        paramMap.put("symbol", symbol);
        paramMap.put("aux", aux);

        return super.getResponseFromEndpoint(CRYPTOCURRENCY_INFO_ENDPOINT, paramMap);
    }
    public ResponseEntity<Object> getListingsLatest(Long start, Long limit, Double priceMin, Double priceMax, Double marketCapMin, Double marketCapMax, Double volume24hMin, Double volume24hMax, Double circulatingSupplyMin, Double circulatingSupplyMax, Double percentChange24hMin, Double percentChange24hMax, String convert, String convertId, String sort, String sortDir, String cryptocurrencyType, String tag, String aux) {
        HashMap<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("start", (start != null ? Long.toString(start) : null));
        paramMap.put("limit", (limit != null ? Long.toString(limit) : null));
        paramMap.put("price_min", (priceMin != null ? Double.toString(priceMin) : null));
        paramMap.put("price_max", (priceMax != null ? Double.toString(priceMax) : null));
        paramMap.put("market_cap_min", (marketCapMin != null ? Double.toString(marketCapMin) : null));
        paramMap.put("market_cap_max", (marketCapMax != null ? Double.toString(marketCapMax) : null));
        paramMap.put("volume_24h_min", (volume24hMin != null ? Double.toString(volume24hMin) : null));
        paramMap.put("volume_24h_max", (volume24hMax != null ? Double.toString(volume24hMax) : null));
        paramMap.put("circulating_supply_min", (circulatingSupplyMin != null ? Double.toString(circulatingSupplyMin) : null));
        paramMap.put("circulating_supply_max", (circulatingSupplyMax != null ? Double.toString(circulatingSupplyMax) : null));
        paramMap.put("percent_change_24h_min", (percentChange24hMin != null ? Double.toString(percentChange24hMin) : null));
        paramMap.put("percent_change_24h_max", (percentChange24hMax != null ? Double.toString(percentChange24hMax) : null));
        paramMap.put("convert", convert);
        paramMap.put("convert_id", convertId);
        paramMap.put("sort", sort);
        paramMap.put("sort_dir", sortDir);
        paramMap.put("cryptocurrency_type", cryptocurrencyType);
        paramMap.put("tag", tag);
        paramMap.put("aux", aux);

        return super.getResponseFromEndpoint(CRYPTOCURRENCY_LISTINGS_LATEST_ENDPOINT, paramMap);
    }

}
