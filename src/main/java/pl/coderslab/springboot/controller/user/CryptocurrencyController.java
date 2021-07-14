package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class CryptocurrencyController {
    private final OwnedcryptocurrenciesRepository ownedcryptocurrenciesRepo;
    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final StorageRepository storageRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public CryptocurrencyController(OwnedcryptocurrenciesRepository ownedcryptocurrenciesRepo, CryptocurrencyRepository cryptocurrencyRepository, StorageRepository storageRepository, UserRepository userRepository, UserService userService) {
        this.ownedcryptocurrenciesRepo = ownedcryptocurrenciesRepo;
        this.cryptocurrencyRepository = cryptocurrencyRepository;
        this.storageRepository = storageRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/allCrypto")
    public String allCrypto(Model model) {
        List<Cryptocurrencies> cryptocurrencies = cryptocurrencyRepository.findAll();
        model.addAttribute("cryptocurrencies", cryptocurrencies);
        return "user/yourCrypto/allCrypto";
    }

    @RequestMapping("/yourCrypto")
    public String yourCrypto(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptocurrenciesRepo.findByUser(user);
        model.addAttribute("ownedcryptocurrencies", ownedcryptocurrencies);
        return "user/yourCrypto/yourCrypto";
    }

    @GetMapping("/addCrypto")
    public String addCrypto(Model model, Authentication authentication) {
        model.addAttribute("ownedcryptocurrencies", new Ownedcryptocurrencies());
        model.addAttribute("cryptocurrencies", cryptocurrencyRepository.findAll());
        model.addAttribute("storage", storageRepository.findAll());
        model.addAttribute("user", userService.findByUserName(authentication.getName()));
        return "user/yourCrypto/addCrypto";
    }

    @PostMapping(value = "/cryptoSuccess")
    public String processAddingCrypto(@Valid Ownedcryptocurrencies ownedcryptocurrencies, BindingResult result) {
        if (result.hasErrors()) {
            return "user/yourCrypto/addCrypto";
        } else {
            ownedcryptocurrenciesRepo.save(ownedcryptocurrencies);
            return "user/yourCrypto/cryptoSuccess";
        }
    }
    @GetMapping(value = {"/cryptoDetails/{id}"})
    public String storageDetails(@PathVariable long id, Model model) {
        Optional<Ownedcryptocurrencies> cryptoDetails = ownedcryptocurrenciesRepo.findById(id);
        if (cryptoDetails.isPresent()) {
            model.addAttribute("cryptoDetails", cryptoDetails.get());
        }
        else{ return "user/userError";}
        return "user/yourCrypto/cryptoDetails";
    }
    @RequestMapping("/cryptoConfirmDelete")
    public String cryptoConfirmDelete() {
        return "user/yourCrypto/cryptoConfirmDelete";
    }

    @GetMapping(value = {"/cryptoDelete/{id}"})
    public String cryptoDelete(@PathVariable long id) {
        ownedcryptocurrenciesRepo.deleteById(id);
        return "redirect:/yourCrypto";
    }
}

