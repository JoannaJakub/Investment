package pl.coderslab.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.model.*;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
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
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @RequestMapping("/yourStocks")
    public String yourStocks(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        List<Ownedstocks> ownedstocks = ownedstocksRepository.findByUser(user);
        model.addAttribute("ownedstocks", ownedstocks);
        return "yourStocks";
    }

    @GetMapping("/addStocks")
    public String addStocks(Model model) {
        model.addAttribute("ownedstocks", new Ownedstocks());
        model.addAttribute("stocks", stocksRepository.findAll());
        model.addAttribute("storage", storageRepository.findAll());
        return "addStocks";
    }

    @PostMapping(value = "/stocksSuccess")
    public String processAddingStocks(@Valid Ownedstocks ownedstocks, BindingResult result
            , @AuthenticationPrincipal UserDetails customUser) {
        if (result.hasErrors()) {
            return "addStocks";
        }   String entityUser = customUser.getUsername();
            Long user = userRepository.findByUsername(entityUser).getId();
            ownedstocksRepository.save(ownedstocks);
            return "stocksSuccess";

    }


    @GetMapping("/allStocks")
    public String allStocks(Model model) {
        List<Stocks> stocks = stocksRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "allStocks";
    }


}




