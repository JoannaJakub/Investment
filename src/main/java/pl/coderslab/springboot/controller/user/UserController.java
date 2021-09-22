package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.RoleRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserController(UserService userService, UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

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
    public String myDetailsEditSave(@Valid User user,  BindingResult result) {
     /*   user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(passwordEncoder.encode(user.getPassword()));
        String password = passwordEncoder.encode(user.getPassword());
        Role role = roleRepository.findById(1L).orElse(null);
        System.out.println( user.getPassword());
        if(role != null){
            user.setRole(new HashSet<>(Collections.singletonList(role)));

            userRepository.save(user);
        }*/
        if (result.hasErrors()) {
            return "user/user/userEdit";
        } else if (userService.findByUserName(user.getUsername().toLowerCase()) != null) {
            result.addError(new FieldError(user.toString(), "username", "Email is already taken"));
        } else if (!(user.getPassword().equals(user.getPasswordConfirm()))) {
            result.addError(new FieldError(user.toString(), "passwordConfirm", "Passwords dont match"));
        } else {
            userService.save(user);
        }
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

    @GetMapping(value = {"/userChangePassword"})
    public String userChangePasswordForm(@AuthenticationPrincipal UserDetails customUser, Model model) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        model.addAttribute("userChangePassword", user);
        return "user/user/userChangePassword";
    }

    @PostMapping(value = "/userChangePassword")
    public String userPasswordChange(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "user/user/userChangePassword";
        }else if(!(user.getPassword().equals(user.getPasswordConfirm()))){
            result.addError(new FieldError(user.toString(), "passwordConfirm", "Passwords dont match"));
        } else {
            userService.save(user);
        }
        return "redirect:/userPasswordChangeSuccess";
    }


}
