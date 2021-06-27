package pl.coderslab.springboot.controller.admin;


import org.springframework.security.access.annotation.Secured;
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

@Secured("ROLE_ADMIN")
@Controller
public class AdminRoleController {
    private final StocksRepository stocksRepository;
    private final UserRepository userRepo;
    private final RoleRepository roleRepository;
    private final CryptocurrencyRepository cryptocurrencyRepo;
    private final UserService userService;
    private final StorageRepository storageRepository;

    public AdminRoleController(StocksRepository stocksRepository, UserRepository userRepo, RoleRepository roleRepository, CryptocurrencyRepository cryptocurrencyRepo, UserService userService, StorageRepository storageRepository) {
        this.stocksRepository = stocksRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.cryptocurrencyRepo = cryptocurrencyRepo;
        this.userService = userService;
        this.storageRepository = storageRepository;
    }
    @GetMapping("role")
    public String roles(Model model) {
        List<Role> role = roleRepository.findAll();
        model.addAttribute("role", role);
        return "admin/role/roles";
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


    @RequestMapping("/roleConfirmDelete")
    public String roleConfirmDelete() {
        return "admin/roleConfirmDelete";
    }


    @GetMapping(value = {"/roleDelete/{id}"})
    public String roleDelete(@PathVariable long id) {
        roleRepository.deleteById(id);
        return "redirect:/role";
    }
    @GetMapping(value = {"/roleEdit/{id}"})
    public String roleEditForm(@PathVariable long id, Model model) {
        model.addAttribute("roleEdit", roleRepository.findById(id));
        return "admin/role/roleEdit";
    }

    @PostMapping(value = {"roleEdit/{id}"})
    public String roleEditSave(@Valid Role role) {
        roleRepository.save(role);
        return "redirect:/roleConfirmEditing/{id}";
    }

    @RequestMapping("/roleConfirmEditing/{id}")
    public String userConfirmEditing(@PathVariable long id, Model model) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            model.addAttribute("roleConfirmEdit", role.get());
        } else {
            return "admin/adminError";
        }
        return "admin/role/roleConfirmEdit";
    }
    @GetMapping(value = {"/roleDetails/{id}"})
    public String roleDetails(@PathVariable long id, Model model) {
        Optional<Role> roleDetails = roleRepository.findById(id);
        if (roleDetails.isPresent()) {
            model.addAttribute("roleDetails", roleDetails.get());
        }
        else{ return "admin/adminError";}

        return "admin/role/roleDetails";
    }
}

