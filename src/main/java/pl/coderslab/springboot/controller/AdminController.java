package pl.coderslab.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springboot.model.Role;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.repository.RoleRepository;
import pl.coderslab.springboot.repository.StocksRepository;
import pl.coderslab.springboot.repository.UserRepository;

import java.util.List;

@Controller
public class AdminController {
    private final StocksRepository stocksRepository;
    private final UserRepository userRepo;
    private final RoleRepository roleRepository;
    private final CryptocurrencyRepository cryptocurrencyRepo;

    public AdminController(StocksRepository stocksRepository, UserRepository userRepo, RoleRepository roleRepository, CryptocurrencyRepository cryptocurrencyRepo) {
        this.stocksRepository = stocksRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
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
    @GetMapping("role")
    public String roles(Model model) {
        List<Role> role = roleRepository.findAll();
        model.addAttribute("role", role);
        return "admin/roles";
    }
}
