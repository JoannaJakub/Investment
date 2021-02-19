package pl.coderslab.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.repository.OwnedcryptocurrenciesRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepo;
    @Autowired
    private OwnedcryptocurrenciesRepository ownedcryptocurrenciesRepo;


    @GetMapping("")
    public String viewHomePage() {
        return "landingPage";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @RequestMapping(value = "/register_success", method = RequestMethod.POST)
    public String processRegister(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepo.save(user);
            return "register_success";
        }
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String listUsers(Model model) {
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepo.find10All();
        model.addAttribute("cryptocurrencies", cryptocurrencies);

        return "dashboard";
    }

    /* @GetMapping("/dashboard")
     public String dashboard() {
         return "dashboard";
     }*/
    @GetMapping("/allCrypto")
    public String allCrypto(Model model) {
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepo.findAll();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        return "allCrypto";
    }

    @RequestMapping("/yourCrypto")
    public String yourCrypto(Model model, User user) {
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptocurrenciesRepo.findAllByUser(user);
        model.addAttribute("ownedcryptocurrencies", ownedcryptocurrencies);

        return "yourCrypto";
    }

    @RequestMapping("/yourStocks")
    public String yourStocks(Model model, User user) {
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptocurrenciesRepo.findAllByUser(user);
        model.addAttribute("ownedcryptocurrencies", ownedcryptocurrencies);

        return "yourStocks";
    }

    @GetMapping("/allStocks")
    public String allStocks(Model model) {
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepo.findAll();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        return "allStocks";
    }


    @GetMapping("/addCrypto")
    public String addCrypto(Model model) {
        model.addAttribute("ownedcryptocurrencies", new Ownedcryptocurrencies());
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

    @GetMapping("/addStocks")
    public String addStocks(Model model) {
        model.addAttribute("ownedcryptocurrencies", new Ownedcryptocurrencies());
        return "addStocks";
    }


    @RequestMapping(value = "/stocksSuccess", method = RequestMethod.POST)
    public String processAddingStocks(@Valid Ownedcryptocurrencies ownedcryptocurrencies, BindingResult result) {
        if (result.hasErrors()) {
            return "addStocks";
        } else {
            ownedcryptocurrenciesRepo.save(ownedcryptocurrencies);
            return "stocksSuccess";
        }
    }

    @GetMapping("/storage")
    public String allStorage(Model model, User user) {
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptocurrenciesRepo.findAllByUser(user);
        model.addAttribute("ownedcryptocurrencies", ownedcryptocurrencies);
        return "storage";
    }


    //LANDING PAGE
    @GetMapping("allCryptoLandingPage")
    public String allCryptoLandingPage(Model model) {
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepo.findAll();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        return "allCryptoLandingPage";
    }

    @GetMapping("allStocksLandingPage")
    public String allStocksLandingPage(Model model) {
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepo.findAll();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        return "allStocksLandingPage";
    }

}
