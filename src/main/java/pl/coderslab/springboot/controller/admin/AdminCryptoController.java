package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;

import java.util.List;

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
}
