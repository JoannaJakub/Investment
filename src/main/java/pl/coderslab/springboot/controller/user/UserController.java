package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.ContactRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
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

    @GetMapping(value = {"/myDetailsEdit"})
    public String myDetailsEditForm(@AuthenticationPrincipal UserDetails customUser, Model model) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        model.addAttribute("myDetailsEdit", user);
        return "user/user/userEdit";
    }

    @PostMapping(value = {"myDetailsEdit"})
    public String myDetailsEditSave(@Valid User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        return "redirect:/myDetailsConfirmEditing";
    }

    @RequestMapping("/myDetailsConfirmEditing")
    public String myDetailsConfirmEditing(@AuthenticationPrincipal UserDetails customUser, Model model) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        model.addAttribute("myDetailsConfirmEdit", user);
        return "user/user/userConfirmEdit";
    }

    @RequestMapping("/userUserConfirmDelete")
    public String userUserConfirmDelete() {
        return "user/user/userConfirmDelete";
    }

    @GetMapping(value = {"/userUserDelete"})
    public String userUserDelete(@AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        userService.delete(user.getId());
        return "redirect:/dashboard";
    }
}
