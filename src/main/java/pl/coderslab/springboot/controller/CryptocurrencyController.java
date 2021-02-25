package pl.coderslab.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.CryptocurrencyService;
import javax.validation.Valid;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CryptocurrencyController {


    @Autowired
    StocksRepository stocksRepository;
    @Autowired
    OwnedcryptocurrenciesRepository ownedcryptocurrenciesRepo;
    @Autowired
    CryptocurrencyRepository cryptocurrencyRepository;
    @Autowired
    OwnedstocksRepository ownedstocksRepository;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/allCrypto")
    public String allCrypto(Model model) {
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepository.findAll();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        return "allCrypto";
    }


    @RequestMapping("/yourCrypto")
    public String yourCrypto(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptocurrenciesRepo.findUsersCryptoById(entityUser);
        model.addAttribute("ownedcryptocurrencies", ownedcryptocurrencies);

        return "yourCrypto";
    }


    @GetMapping("/addCrypto")
    public String addCrypto(Model model) {
        model.addAttribute("ownedcryptocurrencies", new Ownedcryptocurrencies());
        model.addAttribute("cryptocurrencies", cryptocurrencyRepository.findAll());
        model.addAttribute("storage", storageRepository.findAll());
        return "addCrypto";
    }

    @RequestMapping(value = "/cryptoSuccess", method = RequestMethod.POST)
    public String processAddingCrypto(@Valid Ownedcryptocurrencies ownedcryptocurrencies, BindingResult result) {
        if (result.hasErrors()) {
            return "addCrypto";
        } else {
            ownedcryptocurrenciesRepo.save(ownedcryptocurrencies);
            return "cryptoSuccess";
        }
    }






    @Autowired
    private CryptocurrencyService cryptocurrencyService;

    @GetMapping("/list")
    public Iterable<Cryptocurrencies> list() {
        return cryptocurrencyService.list();
    }

    @GetMapping(path = "map", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getMap(
            @RequestParam(required = false, name = "listing_status") String listingStatus,
            @RequestParam(required = false) Long start,
            @RequestParam(required = false) Long limit,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String symbol,
            @RequestParam(required = false) String aux) {
        return this.cryptocurrencyService.getMap(listingStatus, start, limit, sort, symbol, aux);
    }

    @GetMapping(path = "info", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getInfo(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String slug,
            @RequestParam(required = false) String symbol,
            @RequestParam(required = false) String aux) {
        return this.cryptocurrencyService.getInfo(id, slug, symbol, aux);
    }

    @GetMapping(path = "listings/latest",  produces = MediaType.APPLICATION_JSON_VALUE)
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

       /* @GetMapping(path = "listings/latest",  produces = MediaType.APPLICATION_JSON_VALUE)
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
            System.out.println( start);
            return this.cryptocurrencyService.getListingsLatest(
                    start, limit, priceMin, priceMax, marketCapMin, marketCapMax,
                    volume24hMin, volume24hMax, circulatingSupplyMin, circulatingSupplyMax,
                    percentChange24hMin, percentChange24hMax, convert, convertId,
                    sort, sortDir, cryptocurrencyType, tag, aux);*/
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

