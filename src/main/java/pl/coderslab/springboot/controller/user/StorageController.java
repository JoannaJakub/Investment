package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.StorageRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StorageController {
    private final StorageRepository storageRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public StorageController(StorageRepository storageRepository, UserRepository userRepository, UserService userService) {
        this.storageRepository = storageRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/storage")
    public String storage(Model model, @AuthenticationPrincipal UserDetails customUser) {
        List<Storage> storage = storageRepository.findAll();
        if (!storage.isEmpty()) {
            model.addAttribute("storage", storage);
        } else {
            return "user/userError";
        }
        return "user/storage/storage";
    }

    @GetMapping("/yourStorage")
    public String yourStorage(Model model, @AuthenticationPrincipal UserDetails customUser, Authentication authentication) {
        User user = userService.findByUserName(authentication.getName());
        Optional<Storage> yourStorage = storageRepository.findById(user.getId());
        if (!yourStorage.isEmpty()) {
            model.addAttribute("yourStorage", yourStorage);
        } else {
            return "user/userError";
        }
        return "user/storage/yourStorage";
    }

    @GetMapping("/addStorage")
    public String addStorage(Model model) {
        model.addAttribute("storage", new Storage());
        return "user/storage/addStorage";
    }

    @PostMapping(value = "/storageSuccess")
    public String processAddingStorage(@Valid Storage storage, BindingResult result) {
        if (result.hasErrors()) {
            return "user/storage/addStorage";
        } else {
            storageRepository.save(storage);
            return "user/storage/storageSuccess";
        }
    }

}
