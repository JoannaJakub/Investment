package pl.coderslab.springboot.controller.admin;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    private final StocksRepository stocksRepository;
    private final UserRepository userRepo;
    private final RoleRepository roleRepository;
    private final CryptocurrencyRepository cryptocurrencyRepo;
    private final UserService userService;
    private final StorageRepository storageRepository;

    public AdminController(StocksRepository stocksRepository, UserRepository userRepo, RoleRepository roleRepository, CryptocurrencyRepository cryptocurrencyRepo, UserService userService, StorageRepository storageRepository) {
        this.stocksRepository = stocksRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.cryptocurrencyRepo = cryptocurrencyRepo;
        this.userService = userService;
        this.storageRepository = storageRepository;
    }


    @GetMapping("adminDashboard")
    public String adminDashboard(Model model) {

        return "admin/adminDashboard";
    }

}

