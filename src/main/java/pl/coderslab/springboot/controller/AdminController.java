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
import pl.coderslab.springboot.model.Storage;
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


    @GetMapping(value = {"/userRole/{id}"})
    public String oneUserContacts(@PathVariable long id, Model model) {
        List<User> role = userService.findByRoleId(id);
        model.addAttribute("userRole", role);
        return "admin/userRole";
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
        return "admin/userConfirmDelete";
    }

    @GetMapping(value = {"/userDelete/{id}"})
    public String userDelete(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/users";
    }
    @GetMapping("/addRole")
    public String addRole(Model model) {
        model.addAttribute("role", new Role());
        return "admin/addRole";
    }


    @PostMapping(value = "/roleSuccess")
    public String processRoleSuccess(@Valid Role role, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/addRole";
        } else {
            roleRepository.save(role);
            return "admin/roleSuccess";
        }
    }
    @GetMapping(value = {"/userEdit/{id}"})
    public String userEditForm(@PathVariable long id, Model model) {
        model.addAttribute("userEdit", userRepo.findById(id));
        return "admin/userEdit";
    }

    @PostMapping(value = {"userEdit/{id}"})
    public String userEditSave(@Valid User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        return "redirect:/userConfirmEditing/{id}";
    }

    @RequestMapping("/userConfirmEditing/{id}")
    public String userConfirmEditing(@PathVariable long id, Model model) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            model.addAttribute("userConfirmEdit", user.get());
        }else{ return "admin/adminError";}
        return "admin/userConfirmEdit";
    }
    @GetMapping(value = {"/userDetails/{id}"})
    public String userDetails(@PathVariable long id, Model model) {
        Optional<User> findUser = userRepo.findById(id);
        if (findUser.isPresent()) {
            model.addAttribute("userDetails", findUser.get());
        }
        else{ return "admin/adminError";}

        return "admin/userDetails";
    }
    @GetMapping("adminStorage")
    public String storage(Model model) {
        List<Storage> storage = storageRepository.findAll();
        model.addAttribute("adminStorage", storage);


        return "admin/storage";
    }
    @RequestMapping("/storageConfirmDelete")
    public String storageConfirmDelete() {
        return "admin/storageConfirmDelete";
    }

    @GetMapping(value = {"/storageDelete/{id}"})
    public String storageDelete(@PathVariable long id) {
        storageRepository.deleteById(id);
        return "redirect:/adminStorage";
    }
}
