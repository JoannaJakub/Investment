package pl.coderslab.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

@Controller
public class AdminController {

    @GetMapping("adminDashboard")
    public String adminDashboard(Model model) {
        return "admin/adminDashboard";
    }

}

