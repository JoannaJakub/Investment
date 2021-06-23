package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminStorageController {
    private final StocksRepository stocksRepository;
    private final UserRepository userRepo;
    private final RoleRepository roleRepository;
    private final CryptocurrencyRepository cryptocurrencyRepo;
    private final UserService userService;
    private final StorageRepository storageRepository;

    public AdminStorageController(StocksRepository stocksRepository, UserRepository userRepo, RoleRepository roleRepository, CryptocurrencyRepository cryptocurrencyRepo, UserService userService, StorageRepository storageRepository) {
        this.stocksRepository = stocksRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.cryptocurrencyRepo = cryptocurrencyRepo;
        this.userService = userService;
        this.storageRepository = storageRepository;
    }


    @GetMapping("adminStorage")
    public String storage(Model model) {
        List<Storage> storage = storageRepository.findAll();
        model.addAttribute("adminStorage", storage);
        return "admin/storage/storage";
    }

    @RequestMapping("/storageConfirmDelete")
    public String storageConfirmDelete() {
        return "admin/storage/storageConfirmDelete";
    }

    @GetMapping(value = {"/storageDelete/{id}"})
    public String storageDelete(@PathVariable long id) {
        storageRepository.deleteById(id);
        return "redirect:/adminStorage";
    }

    @GetMapping(value = {"/storageDetails/{id}"})
    public String storageDetails(@PathVariable long id, Model model) {
        Optional<Storage> storageDetails = storageRepository.findById(id);
        if (storageDetails.isPresent()) {
            model.addAttribute("storageDetails", storageDetails.get());
        }
        else{ return "admin/adminError";}

        return "admin/storage/storageDetails";
    }
}
