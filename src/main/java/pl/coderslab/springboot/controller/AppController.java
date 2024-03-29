package pl.coderslab.springboot.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.model.*;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

@Controller
public class AppController {
    private final StocksRepository stocksRepository;
    private final CryptocurrencyRepository cryptocurrencyRepo;
    private final UserService userService;

    public AppController(StocksRepository stocksRepository, CryptocurrencyRepository cryptocurrencyRepo, UserService userService) {
        this.stocksRepository = stocksRepository;
        this.cryptocurrencyRepo = cryptocurrencyRepo;
        this.userService = userService;
    }


    @GetMapping("")
    public String viewHomePage() {
        return "main/landingPage";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "main/register";
    }

    @PostMapping(value = "/register_success")
    public String processRegister(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "main/register";
        } else if (userService.findByUserName(user.getUsername().toLowerCase()) != null) {
            result.addError(new FieldError(user.toString(), "username", "Email is already taken"));
        }else if(!(user.getPassword().equals(user.getPasswordConfirm()))){
            result.addError(new FieldError(user.toString(), "passwordConfirm", "Passwords dont match"));
        } else {
            user.getRole();
            userService.save(user);
            return "main/register_success";
        }
        return "main/register";
    }

    @GetMapping(value = {"/login"})
    public String login(@RequestParam(value = "error", defaultValue = "false") boolean loginError) {
        if (loginError) {
            return "main/loginError";
        } else {
            return "main/login";
        }
    }

    @GetMapping("/dashboard")
    public String listUsers(Model model){
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepo.find10All();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        List<Stocks> stocks = stocksRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "user/dashboard";
    }

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    //LANDING PAGE
    @GetMapping("allCryptoLandingPage")
    public String allCryptoLandingPage(Model model) {
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepo.findAll();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        return "main/allCryptoLandingPage";
    }

    @GetMapping("allStocksLandingPage")
    public String allStocksLandingPage(Model model) {
        List<Stocks> stocks = stocksRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "main/allStocksLandingPage";
    }

    @GetMapping(value= {"/default"})
    public String defaultAfterLogin() {
        Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String admin = "ADMIN";
        if (myRole.equals(admin)) {
            return "redirect:/adminDashboard";
        }
        return "redirect:/dashboard";
    }

}
