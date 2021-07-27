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
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminUserController {
    private final UserRepository userRepo;
    private final UserService userService;
    private final OwnedcryptocurrenciesRepository ownedcryptoRepo;
    private final OwnedstocksRepository ownedstocksRepo;

    public AdminUserController(UserRepository userRepo, UserService userService, OwnedcryptocurrenciesRepository ownedcryptoRepo, OwnedstocksRepository ownedstocksRepo) {
        this.userRepo = userRepo;
        this.userService = userService;
        this.ownedcryptoRepo = ownedcryptoRepo;
        this.ownedstocksRepo = ownedstocksRepo;
    }

    @GetMapping("users")
    public String users(Model model) {
        List<User> user = userService.findAll();
        model.addAttribute("user", user);
        return "admin/user/users";
    }

    @GetMapping("/adminRegister")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/user/adminRegister";
    }

    @PostMapping(value = "/adminRegisterSuccess")
    public String processRegister(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/user/adminRegister";
        } else if (userRepo.findByUsername(user.getUsername().toLowerCase()) != null) {
            result.addError(new FieldError(user.toString(), "username", "Email is already taken"));
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepo.save(user);
            return "admin/user/adminRegisterSuccess";
        }
        return "admin/user/adminRegister";
    }

    @RequestMapping("/userConfirmDelete")
    public String userConfirmDelete() {
        return "admin/user/userConfirmDelete";
    }

    @GetMapping(value = {"/userDelete/{id}"})
    public String userDelete(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping(value = {"/userEdit/{id}"})
    public String userEditForm(@PathVariable long id, Model model) {
        model.addAttribute("userEdit", userRepo.findById(id));
        return "admin/user/userEdit";
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
        } else {
            return "admin/adminError";
        }
        return "admin/user/userConfirmEdit";
    }

    @GetMapping(value = {"/userDetails/{id}"})
    public String userDetails(@PathVariable long id, Model model) {
        Optional<User> findUser = userRepo.findById(id);
        if (findUser.isPresent()) {
            model.addAttribute("userDetails", findUser.get());
        } else {
            return "admin/adminError";
        }
        return "admin/user/userDetails";
    }

    @GetMapping(value = {"/changeRole/{id}"})
    public String changeRoleForm(@PathVariable long id, Model model) {
        model.addAttribute("changeRole", userRepo.findById(id));
        return "admin/user/changeRole";
    }

    @PostMapping(value = {"changeRole/{id}"})
    public String changeRoleSave(@Valid User user) {
        userService.saveUser(user);
        return "redirect:/changeRoleConfirm/{id}";
    }

    @RequestMapping("/changeRoleConfirm/{id}")
    public String changeRoleConfirm(@PathVariable long id, Model model) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            model.addAttribute("userConfirmEdit", user.get());
        } else {
            return "admin/adminError";
        }
        return "admin/user/changeRoleConfirmEdit";
    }

    @RequestMapping("/userInvest/{id}")
    public String userInvest( @PathVariable long id, Model model) {
        Optional<User> user = userRepo.findById(id);
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptoRepo.findInvestByUser(user);
        List<Ownedstocks> ownedstocks = ownedstocksRepo.findInvestByUser(user);
        model.addAttribute("userInvestCrypto", ownedcryptocurrencies);
        model.addAttribute("userStocks", ownedstocks);
        return "admin/user/userInvest";
    }
    @RequestMapping("/userCrypto/{id}")
    public String userCrypto( @PathVariable long id, Model model) {
        Optional<User> user = userRepo.findById(id);
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptoRepo.findInvestByUser(user);
        model.addAttribute("userCrypto", ownedcryptocurrencies);
        return "admin/user/userCrypto";
    }
    @RequestMapping("/userStocks/{id}")
    public String userStocks( @PathVariable long id, Model model) {
        Optional<User> user = userRepo.findById(id);
        List<Ownedstocks> ownedstocks = ownedstocksRepo.findInvestByUser(user);
        model.addAttribute("userStocks", ownedstocks);
        return "admin/user/userStocks";
    }
}

