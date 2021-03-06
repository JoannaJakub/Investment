package pl.coderslab.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.model.*;
import pl.coderslab.springboot.repository.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepo;
    @Autowired
    private StocksRepository stocksRepository;


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
        } else if (userRepo.findByUsername(user.getUsername().toLowerCase()) != null) {
            result.addError(new FieldError(user.toString(), "username", "Email is already taken"));
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepo.save(user);
            return "register_success";
        }
        return "register";
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", defaultValue = "false") boolean loginError) {
        if (loginError) {
            return "loginError";
        } else {
            return "login";
        }
    }


    @GetMapping("/dashboard")
    public String listUsers(Model model){
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepo.find10All();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        List<Stocks> stocks = stocksRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "dashboard";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
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
        List<Stocks> stocks = stocksRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "allStocksLandingPage";
    }

}
