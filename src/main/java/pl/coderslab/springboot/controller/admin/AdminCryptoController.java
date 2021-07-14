package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminCryptoController {
    private final CryptocurrencyRepository cryptocurrencyRepository;

    public AdminCryptoController(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
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
        return "admin/crypto/addCrypto";
    }
    @PostMapping(value = "/adminCryptoSuccess")
    public String processAdminCryptoSuccess(@Valid Cryptocurrencies crypto, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/crypto/addCrypto";
        } else {
            cryptocurrencyRepository.save(crypto);
            return "admin/crypto/cryptoSuccess";
        }
    }
    @RequestMapping("/adminCryptoConfirmDelete")
    public String adminCryptoConfirmDelete() {
        return "admin/crypto/cryptoConfirmDelete";
    }

    @GetMapping(value = {"/adminCryptoDelete/{id}"})
    public String adminCryptoDelete(@PathVariable long id) {
        cryptocurrencyRepository.deleteById(id);
        return "redirect:/adminCrypto";
    }

    @GetMapping(value = {"/adminCryptoEdit/{id}"})
    public String adminCryptoEditForm(@PathVariable long id, Model model) {
        model.addAttribute("adminCryptoEdit", cryptocurrencyRepository.findById(id));
        return "admin/crypto/cryptoEdit";
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
        return "admin/crypto/cryptoDetails";
    }
}
