package pl.coderslab.springboot.controller.admin;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Role;
import pl.coderslab.springboot.repository.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Secured("ROLE_ADMIN")
@Controller
public class AdminRoleController {
    private final RoleRepository roleRepository;

    public AdminRoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
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
        return "admin/role/addRole";
    }

    @PostMapping(value = "/roleSuccess")
    public String processRoleSuccess(@Valid Role role, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/role/addRole";
        } else {
            roleRepository.save(role);
            return "admin/role/roleSuccess";
        }
    }

    @RequestMapping("/roleConfirmDelete")
    public String roleConfirmDelete() {
        return "admin/role/roleConfirmDelete";
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

    @GetMapping(value = {"/userRole/{id}"})
    public String oneUserContacts(@PathVariable long id, Model model) {
        List<Role> role = roleRepository.findAllById(Collections.singleton(id));
        model.addAttribute("userRole", role);
        return "admin/role/userRole";
    }

}

