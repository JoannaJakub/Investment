package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class StorageController {
    private final StorageRepository storageRepository;
    private final OwnedstocksRepository ownedstocksRepo;
    private final OwnedcryptocurrenciesRepository ownedcryptocRepo;
    private final UserRepository userRepository;


    public StorageController(StorageRepository storageRepository, OwnedstocksRepository ownedstocksRepo, OwnedcryptocurrenciesRepository ownedcryptocRepo, UserRepository userRepository) {
        this.storageRepository = storageRepository;
        this.ownedstocksRepo = ownedstocksRepo;
        this.ownedcryptocRepo = ownedcryptocRepo;
        this.userRepository = userRepository;
    }

    @GetMapping("/storage")
    public String storage(Model model) {
        List<Storage> storage = storageRepository.findAll();
        if (!storage.isEmpty()) {
            model.addAttribute("storage", storage);
        } else {
            return "user/userError";
        }
        return "user/storage/storage";
    }

    @RequestMapping("/yourStorage")
    public String yourStorage(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        Set<Ownedstocks> ownedStocks = ownedstocksRepo.findStorageByUser(user);
        List<Ownedcryptocurrencies> ownedCrypto = ownedcryptocRepo.findByUser(user);
        if (!ownedStocks.isEmpty()) {
            model.addAttribute("yourStocksStorage", ownedStocks);
        } else {
            model.addAttribute("errorStocks", "Nothing to display");
        }
        if (!ownedCrypto.isEmpty()) {
            model.addAttribute("yourCryptoStorage", ownedCrypto);
        } else {
            model.addAttribute("error", "Nothing to display");
        }
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

    @GetMapping(value = {"/storageDetails/{id}"})
    public String storageDetails(@PathVariable long id, Model model) {
        Optional<Storage> storageDetails = storageRepository.findById(id);
        if (storageDetails.isPresent()) {
            model.addAttribute("storageDetails", storageDetails.get());
        } else {
            return "user/userError";
        }
        return "user/storage/storageDetails";
    }

    @GetMapping(value = {"/allStocksFromStorage/{id}"})
    public String allStocksFromStorage(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        List<Ownedstocks> ownedStocks = ownedstocksRepo.findByUser(user);

        if (!ownedStocks.isEmpty()) {
            model.addAttribute("allStocksFromStorage", ownedStocks);
        } else {
            return "user/userError";
        }
        return "user/storage/allStocksFromStorage";
    }

    @GetMapping(value = {"/allCryptoFromStorage/{id}"})
    public String allCryptoFromStorage(@AuthenticationPrincipal UserDetails customUser, Model model) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        List<Ownedcryptocurrencies> ownedCrypto = ownedcryptocRepo.findByUser(user);

        if (!ownedCrypto.isEmpty()) {
            model.addAttribute("allCryptoFromStorage", ownedCrypto);
        } else {
            return "user/userError";
        }
        return "user/storage/allCryptoFromStorage";
    }
}
