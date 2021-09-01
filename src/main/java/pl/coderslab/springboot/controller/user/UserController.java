package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.ContactRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.service.UserService;

import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        ;
    }


    @GetMapping(value = {"/myDetails"})
    public String userDetails(@AuthenticationPrincipal UserDetails customUser, Model model) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        model.addAttribute("myDetails", user);

        return "user/user/userDetails";
    }


}
