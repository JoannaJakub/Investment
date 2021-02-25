package pl.coderslab.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.model.*;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Controller
public class StocksController {
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
    @Autowired
    UserService userService;

    @RequestMapping("/yourStocks")
    public String yourStocks(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        List<Ownedstocks> ownedstocks = ownedstocksRepository.findSomeById(entityUser);
        model.addAttribute("ownedstocks", ownedstocks);

        return "yourStocks";
    }

    @GetMapping("/addStocks")
    public String addStocks(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        System.out.println(entityUser);
     //   User user = userRepository.findUserById(entityUser);
      //  System.out.println(user);
       // System.out.println(userRepository.findIdByUsername(String.valueOf(entityUser)));
       // model.addAttribute("user",entityUser);*/
        model.addAttribute("user", userRepository.findUserById(entityUser));
    //    model.addAttribute("user", ownedstocksRepository.findSomeById(entityUser));
        model.addAttribute("ownedstocks",new Ownedstocks());
        model.addAttribute("stocks", stocksRepository.findAll());
        model.addAttribute("storage", storageRepository.findAll());
        return "addStocks";
    }

    @RequestMapping(value = "/stocksSuccess", method = RequestMethod.POST)
    public String processAddingStocks(@Valid Ownedstocks ownedstocks, BindingResult result) {
        if (result.hasErrors()) {
            return "addStocks";
        } else {

            ownedstocksRepository.save(ownedstocks);
            return "stocksSuccess";
        }
    }


    @GetMapping("/allStocks")
    public String allStocks(Model model) {
        List<Stocks> stocks = stocksRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "allStocks";
    }









    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String INSERT_SQL = "INSERT INTO stocks(name, price, change, currency, bid) values(?,?,?,?,?)";
    private Object Stock= YahooFinance.get("INTC");;

    public StocksController() throws IOException {
    }

    @RequestMapping(value = "/api1")
    public String processStocks(@Valid Stocks stocks)throws IOException {
        Stock stock = YahooFinance.get("INTC");

        String name = stock.getName();
        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        String currency = stock.getCurrency();
        BigDecimal bid = stock.getDividend().getAnnualYieldPercent();


      /*  SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", stocks.getName())
                .addValue("price", stocks.getPrice())
                .addValue("change", stocks.getChange())
                .addValue("currency", stock.getCurrency())
                .addValue("bid", stocks.getChange());*/
        System.out.println(String.format(name+ price+ change+ currency+ bid));

/*
        String stocksLists = name+price+change;
        System.out.println(stocksLists);*/
        stocksRepository.saveStocks(price, change, currency, bid, name);
       // stocksRepository.save(stocks);
            return "success";
        }
    }





