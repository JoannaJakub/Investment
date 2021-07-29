package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.repository.OwnedcryptocurrenciesRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminOwnedCryptoController {
    private final OwnedcryptocurrenciesRepository ownedcryptoRepo;

    public AdminOwnedCryptoController(OwnedcryptocurrenciesRepository ownedcryptoRepo) {
        this.ownedcryptoRepo = ownedcryptoRepo;
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

    @GetMapping(value = {"/usersOwnedCryptoEdit/{id}"})
    public String usersOwnedCryptoEditForm(@PathVariable long id, Model model) {
        model.addAttribute("adminUsersCryptoEdit", ownedcryptoRepo.findById(id));
        return "admin/crypto/usersOwnedCryptoEdit";
    }

    @PostMapping(value = {"usersOwnedCryptoEdit/{id}"})
    public String usersOwnedCryptoEditSave(@Valid Ownedcryptocurrencies ownedCrypto) {
        ownedcryptoRepo.save(ownedCrypto);
        return "redirect:/usersOwnedCryptoConfirmEditing/{id}";
    }

    @RequestMapping("/usersOwnedCryptoConfirmEditing/{id}")
    public String usersOwnedCryptoConfirmEditing(@PathVariable long id, Model model) {
        Optional<Ownedcryptocurrencies> crypto = ownedcryptoRepo.findById(id);
        if (crypto.isPresent()) {
            model.addAttribute("adminUsersCryptoEdit", crypto.get());
        } else {
            return "admin/adminError";
        }
        return "admin/crypto/usersOwnedCryptoConfirmEdit";
    }

    @GetMapping(value = {"/usersOwnedCryptoDetails/{id}"})
    public String usersOwnedCryptoDetails(@PathVariable long id, Model model) {
        Optional<Ownedcryptocurrencies> cryptoDetails = ownedcryptoRepo.findById(id);
        if (cryptoDetails.isPresent()) {
            model.addAttribute("adminUsersCryptoDetails", cryptoDetails.get());
        } else {
            return "admin/adminError";
        }
        return "admin/crypto/usersOwnedCryptoDetails";
    }

    @GetMapping(value = {"/oneCryptoUser/{id}"})
    public String oneCryptoUser(@PathVariable long id, Model model) {
        List<Ownedcryptocurrencies> oneCryptoUser = ownedcryptoRepo.findUserByCryptocurrenciesId(id);
        System.out.println(oneCryptoUser);
        model.addAttribute("oneCryptoUser", oneCryptoUser);
        return "admin/crypto/oneCryptoUser";
    }
}
