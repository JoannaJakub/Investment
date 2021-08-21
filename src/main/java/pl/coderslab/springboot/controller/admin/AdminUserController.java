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
import pl.coderslab.springboot.excel.AdminUserExcelExporter;
import pl.coderslab.springboot.excel.AdminUsersInvestExcelExporter;
import pl.coderslab.springboot.implementation.UserServiceImpl;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class AdminUserController {
    private final UserRepository userRepo;
    private final UserService userService;
    private final OwnedcryptocurrenciesRepository ownedcryptoRepo;
    private final OwnedstocksRepository ownedstocksRepo;

    public AdminUserController(UserRepository userRepo, UserService userService,
                               OwnedcryptocurrenciesRepository ownedcryptoRepo, OwnedstocksRepository ownedstocksRepo) {
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

    @GetMapping("usersAdminRole/{id}")
    public String usersAdminRole(Model model, @PathVariable long id) {
        Set<User> user=userRepo.findAllByRoleId(2);
        model.addAttribute("adminRole", user);
        return "admin/user/usersAdminRole";
    }

    @GetMapping("usersUserRole/{id}")
    public String usersUserRole(Model model, @PathVariable long id) {
        Set<User> user=userRepo.findAllByRoleId(1);
        model.addAttribute("userRole", user);
        return "admin/user/usersUserRole";
    }

    @GetMapping("/adminUsers/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userRepo.findAll();

        AdminUserExcelExporter excelExporter = new AdminUserExcelExporter(listUsers);

        excelExporter.export(response);
    }
    @GetMapping("/adminUsersInvest/export/excel/{id}")
    public void adminUsersInvestExportToExcel(HttpServletResponse response, @PathVariable long id) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=user_invest_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        Optional<User> user = userRepo.findById(id);
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptoRepo.findInvestByUser(user);
        List<Ownedstocks> ownedstocks = ownedstocksRepo.findInvestByUser(user);
        AdminUsersInvestExcelExporter excelExporter = new AdminUsersInvestExcelExporter(ownedcryptocurrencies,ownedstocks);
        excelExporter.export(response);
    }

    @GetMapping(value = {"/userInvestEdit/{id}"})
    public String userInvestEditForm(@PathVariable long id,@Valid Ownedstocks ownedstocks) {
        ownedstocksRepo.save(ownedstocks);
        return "admin/user/userEdit";
    }

    @PostMapping(value = {"userInvestEdit/{id}"})
    public String userInvestEditSave(@Valid User user,@PathVariable long id, Model model) {
        Optional<Ownedstocks> stocks = ownedstocksRepo.findById(id);
        model.addAttribute("adminUsersStocksEdit", stocks.get());

        return "redirect:/userConfirmEditing/{id}";
    }
}

