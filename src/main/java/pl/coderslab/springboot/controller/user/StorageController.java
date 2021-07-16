package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.OwnedcryptocurrenciesRepository;
import pl.coderslab.springboot.repository.OwnedstocksRepository;
import pl.coderslab.springboot.repository.StorageRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StorageController {
    private final StorageRepository storageRepository;
    private final UserService userService;
    private final OwnedstocksRepository ownedstocksRepo;
    private final OwnedcryptocurrenciesRepository ownedcryptocRepo;
    private final UserRepository userRepository;


    public StorageController(StorageRepository storageRepository, UserService userService, OwnedstocksRepository ownedstocksRepo, OwnedcryptocurrenciesRepository ownedcryptocRepo, UserRepository userRepository) {
        this.storageRepository = storageRepository;
        this.userService = userService;
        this.ownedstocksRepo = ownedstocksRepo;
        this.ownedcryptocRepo = ownedcryptocRepo;
        this.userRepository = userRepository;
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

/*    @GetMapping("/yourStorage1")
    public String yourStorage1(Model model, @AuthenticationPrincipal UserDetails customUser, Authentication authentication) {
        User getNameUser = userService.findByUserName(authentication.getName());
        Optional<Storage> yourStorage = storageRepository.findById(getNameUser.getId());
        if (!yourStorage.isEmpty()) {
            model.addAttribute("yourStorage1", yourStorage);
        } else {
            return "user/userError";
        }
        return "user/storage/yourStorage1";
    }*/

    @RequestMapping("/yourStorage")
    public String yourStorage(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        List<Ownedstocks> ownedStocks = ownedstocksRepo.findByUser(user);
        List<Ownedcryptocurrencies> ownedCrypto = ownedcryptocRepo.findByUser(user);
        model.addAttribute("yourStocksStorage", ownedStocks);
        model.addAttribute("yourCryptoStorage", ownedCrypto);
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
