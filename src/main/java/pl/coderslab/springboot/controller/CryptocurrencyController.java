package pl.coderslab.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.*;

import javax.validation.Valid;
import java.util.List;


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
        User user = userRepository.findByUsername(entityUser);
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptocurrenciesRepo.findByUser(user);
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


}

