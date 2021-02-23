package pl.coderslab.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.StockApi;
import pl.coderslab.springboot.model.*;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.repository.OwnedcryptocurrenciesRepository;
import pl.coderslab.springboot.repository.OwnedstocksRepository;
import pl.coderslab.springboot.repository.StocksRepository;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


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



    @RequestMapping("/yourStocks")
    public String yourStocks(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        List<Ownedstocks> ownedstocks = ownedstocksRepository.findById(entityUser);
        model.addAttribute("ownedstocks", ownedstocks);

        return "yourStocks";
    }

    @GetMapping("/addStocks")
    public String addStocks(Model model) {
        model.addAttribute("ownedstocks", new Ownedstocks());
        return "addStocks";
    }

    @RequestMapping(value = "/stocksSuccess", method = RequestMethod.POST)
    public String processAddingStocks(@Valid Ownedstocks ownedstocks, Model model,BindingResult result) {
        model.addAttribute("ownedstocks", new Ownedstocks());
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





