package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.excel.AdminUserOwnedCryptoExcelExporter;
import pl.coderslab.springboot.excel.AdminUsersInvestCryptoExcelExporter;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.OwnedcryptocurrenciesRepository;
import pl.coderslab.springboot.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminOwnedCryptoController {
    private final OwnedcryptocurrenciesRepository ownedcryptoRepo;
    private final UserRepository userRepo;


    public AdminOwnedCryptoController(OwnedcryptocurrenciesRepository ownedcryptoRepo, UserRepository userRepo) {
        this.ownedcryptoRepo = ownedcryptoRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("usersOwnedCrypto")
    public String usersCrypto(Model model) {
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptoRepo.findAll();
        if (ownedcryptocurrencies.isEmpty()) {
            model.addAttribute("error", "Nothing to display");
        } else {
            model.addAttribute("usersCrypto", ownedcryptocurrencies);
        }
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
        model.addAttribute("oneCryptoUser", oneCryptoUser);
        return "admin/crypto/oneCryptoUser";
    }

    @GetMapping("/adminUsersOwnedCrypto/export/excel")
    public void adminUsersOwnedCryptoExportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ownedcrypto_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Ownedcryptocurrencies> ownedcrypto = ownedcryptoRepo.findAll();

        AdminUserOwnedCryptoExcelExporter excelExporter = new AdminUserOwnedCryptoExcelExporter(ownedcrypto);

        excelExporter.export(response);
    }

    @GetMapping("/adminUsersInvestCrypto/export/excel/{id}")
    public void adminUsersInvestCrypto(HttpServletResponse response, @PathVariable long id) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=user_invest_crypto_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        Optional<User> user = userRepo.findById(id);
        List<Ownedcryptocurrencies> ownedcryptocurrencies = ownedcryptoRepo.findInvestByUser(user);
        AdminUsersInvestCryptoExcelExporter excelExporter = new AdminUsersInvestCryptoExcelExporter(ownedcryptocurrencies);
        excelExporter.export(response);
    }
}
