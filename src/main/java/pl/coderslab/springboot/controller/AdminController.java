package pl.coderslab.springboot.controller;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Role;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.repository.RoleRepository;
import pl.coderslab.springboot.repository.StocksRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {
    private final StocksRepository stocksRepository;
    private final UserRepository userRepo;
    private final RoleRepository roleRepository;
    private final CryptocurrencyRepository cryptocurrencyRepo;
    private final UserService userService;

    public AdminController(StocksRepository stocksRepository, UserRepository userRepo, RoleRepository roleRepository, CryptocurrencyRepository cryptocurrencyRepo, UserService userService) {
        this.stocksRepository = stocksRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.cryptocurrencyRepo = cryptocurrencyRepo;
        this.userService = userService;
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
    @GetMapping("/adminRegister")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/adminRegister";
    }

    @PostMapping(value = "/adminRegisterSuccess")
    public String processRegister(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/adminRegister";
        } else if (userRepo.findByUsername(user.getUsername().toLowerCase()) != null) {
            result.addError(new FieldError(user.toString(), "username", "Email is already taken"));
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepo.save(user);
            return "admin/adminRegisterSuccess";
        }
        return "admin/adminRegister";
    }
    @RequestMapping("/userConfirmDelete")
    public String userConfirmDelete() {
        return "userConfirmDelete2";
    }

    @GetMapping(value = {"/userDelete/{id}"})
    public String userDelete(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}