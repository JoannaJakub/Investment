package pl.coderslab.springboot.controller;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.springboot.UserRepsitory.UserRepository;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    @Autowired
    private UserRepository userRepo;
    @GetMapping("login")
    public String viewHomePage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @RequestMapping("/register_success")
    public String registerSuccess() { return "register_success"; }
}