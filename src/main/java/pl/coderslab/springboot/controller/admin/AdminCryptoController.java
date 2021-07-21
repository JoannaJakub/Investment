package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.repository.OwnedcryptocurrenciesRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminCryptoController {
    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final OwnedcryptocurrenciesRepository ownedcryptoRepo;

    public AdminCryptoController(CryptocurrencyRepository cryptocurrencyRepository, OwnedcryptocurrenciesRepository ownedcryptoRepo) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
        this.ownedcryptoRepo = ownedcryptoRepo;
    }

    @GetMapping("adminCrypto")
    public String crypto(Model model) {
        List<Cryptocurrencies> crypto = cryptocurrencyRepository.findAll();
        model.addAttribute("adminCrypto", crypto);
        return "admin/crypto/adminCrypto";
    }
    @GetMapping("/adminAddCrypto")
    public String adminAddCrypto(Model model) {
        model.addAttribute("adminAddCrypto", new Cryptocurrencies());
        return "admin/crypto/adminAddCrypto";
    }
    @PostMapping(value = "/adminCryptoSuccess")
    public String processAdminCryptoSuccess(@Valid Cryptocurrencies crypto, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/crypto/adminAddCrypto";
        } else {
            cryptocurrencyRepository.save(crypto);
            return "admin/crypto/adminCryptoSuccess";
        }
    }
    @RequestMapping("/adminCryptoConfirmDelete")
    public String adminCryptoConfirmDelete() {
        return "admin/crypto/adminCryptoConfirmDelete";
    }

    @GetMapping(value = {"/adminCryptoDelete/{id}"})
    public String adminCryptoDelete(@PathVariable long id) {
        cryptocurrencyRepository.deleteById(id);
        return "redirect:/adminCrypto";
    }

    @GetMapping(value = {"/adminCryptoEdit/{id}"})
    public String adminCryptoEditForm(@PathVariable long id, Model model) {
        model.addAttribute("adminCryptoEdit", cryptocurrencyRepository.findById(id));
        return "admin/crypto/adminCryptoEdit";
    }

    @PostMapping(value = {"adminCryptoEdit/{id}"})
    public String adminCryptoEditSave(@Valid Cryptocurrencies cryptocurrencies) {
        cryptocurrencyRepository.save(cryptocurrencies);
        return "redirect:/adminCryptoConfirmEditing/{id}";
    }
    @RequestMapping("/adminCryptoConfirmEditing/{id}")
    public String adminCryptoConfirmEditing(@PathVariable long id, Model model) {
        Optional<Cryptocurrencies> crypto = cryptocurrencyRepository.findById(id);
        if (crypto.isPresent()) {
            model.addAttribute("adminCryptoConfirmEdit", crypto.get());
        } else {
            return "admin/adminError";
        }
        return "admin/crypto/adminCryptoConfirmEdit";
    }
    @GetMapping(value = {"/adminCryptoDetails/{id}"})
    public String adminCryptoDetails(@PathVariable long id, Model model) {
        Optional<Cryptocurrencies> cryptoDetails = cryptocurrencyRepository.findById(id);
        if (cryptoDetails.isPresent()) {
            model.addAttribute("adminCryptoDetails", cryptoDetails.get());
        }
        else{ return "admin/adminError";
        }
        return "admin/crypto/adminCryptoDetails";
    }

    @GetMapping("usersOwnedCrypto")
    public String usersCrypto(Model model) {
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptoRepo.findAll();
        model.addAttribute("usersCrypto", ownedcryptocurrencies);
        return "admin/crypto/usersOwnedCrypto";
    }
    @RequestMapping("/usersOwnedCryptoConfirmDelete")
    public String usersOwnedCryptoConfirmDelete() {
        return "admin/crypto/usersOwnedCryptoConfirmDelete";
    }

    @GetMapping(value = {"/usersOwnedCryptoDelete/{id}"})
    public String usersOwnedCryptoDelete(@PathVariable long id) {
        ownedcryptoRepo.deleteById(id);
        return "redirect:/usersOwnedCrypto";
    }
}
