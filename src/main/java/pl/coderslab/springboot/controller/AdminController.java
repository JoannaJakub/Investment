package pl.coderslab.springboot.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.repository.StocksRepository;
import pl.coderslab.springboot.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {
    private final StocksRepository stocksRepository;
    private final UserRepository userRepo;
    private final CryptocurrencyRepository cryptocurrencyRepo;

    public AdminController(StocksRepository stocksRepository, UserRepository userRepo, CryptocurrencyRepository cryptocurrencyRepo) {
        this.stocksRepository = stocksRepository;
        this.userRepo = userRepo;
        this.cryptocurrencyRepo = cryptocurrencyRepo;
    }


    @GetMapping("users")
    public String users(Model model) {
        List<User> user = userRepo.findAll();
        model.addAttribute("user", user);
        return "admin/users";
    }
    @GetMapping("adminDashboard")
    public String adminDashboard(Model model) {

        return "admin/adminDashboard";
    }
}
