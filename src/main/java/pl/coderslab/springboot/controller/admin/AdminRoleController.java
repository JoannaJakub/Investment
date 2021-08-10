package pl.coderslab.springboot.controller.admin;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.excel.AdminRoleExcelExporter;
import pl.coderslab.springboot.model.Role;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Secured("ROLE_ADMIN")
@Controller
public class AdminRoleController {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public AdminRoleController(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
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
        Set<User> user=userRepository.findAllByRoleId(id);
        model.addAttribute("userRole", user);
        return "admin/role/userRole";
    }

    @GetMapping("/adminUsersRole/export/excel")
    public void adminUsersRoleExportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=role_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userRepository.findAll();

        AdminRoleExcelExporter excelExporter = new AdminRoleExcelExporter(listUsers);

        excelExporter.export(response);
    }
}

