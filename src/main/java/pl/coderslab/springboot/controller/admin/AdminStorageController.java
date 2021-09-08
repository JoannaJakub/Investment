package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.excel.*;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.repository.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminStorageController {
    private final StorageRepository storageRepository;
    private final OwnedcryptocurrenciesRepository ownedcryptoRepo;
    private final OwnedstocksRepository ownedstocksRepo;

    public AdminStorageController(StorageRepository storageRepository, OwnedcryptocurrenciesRepository ownedcryptoRepo,
                                  OwnedstocksRepository ownedstocksRepo) {
        this.storageRepository = storageRepository;
        this.ownedcryptoRepo = ownedcryptoRepo;
        this.ownedstocksRepo = ownedstocksRepo;
    }

    @GetMapping("adminStorage")
    public String storage(Model model) {
        List<Storage> storage = storageRepository.findAll();
        model.addAttribute("adminStorage", storage);
        return "admin/storage/storage";
    }

    @GetMapping("/adminAddStorage")
    public String addAdminStorage(Model model) {
        model.addAttribute("adminAddStorage", new Storage());
        return "admin/storage/addStorage";
    }

    @PostMapping(value = "/adminStorageSuccess")
    public String processAdminStorageSuccess(@Valid Storage storage, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/storage/addStorage";
        } else {
            storageRepository.save(storage);
            return "admin/storage/storageSuccess";
        }
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

    @GetMapping(value = {"/adminStorageDetails/{id}"})
    public String adminStorageDetails(@PathVariable long id, Model model) {
        Optional<Storage> storageDetails = storageRepository.findById(id);
        if (storageDetails.isPresent()) {
            model.addAttribute("adminStorageDetails", storageDetails.get());
        } else {
            return "admin/adminError";
        }
        return "admin/storage/storageDetails";
    }

    @GetMapping(value = {"/storageEdit/{id}"})
    public String storageEditForm(@PathVariable long id, Model model) {
        model.addAttribute("storageEdit", storageRepository.findById(id));
        return "admin/storage/storageEdit";
    }

    @PostMapping(value = {"storageEdit/{id}"})
    public String storageEditSave(@Valid Storage storage) {
        storageRepository.save(storage);
        return "redirect:/storageConfirmEditing/{id}";
    }

    @RequestMapping("/storageConfirmEditing/{id}")
    public String storageConfirmEditing(@PathVariable long id, Model model) {
        Optional<Storage> storage = storageRepository.findById(id);
        if (storage.isPresent()) {
            model.addAttribute("storageConfirmEdit", storage.get());
        } else {
            return "admin/adminError";
        }
        return "admin/storage/storageConfirmEdit";
    }

    @GetMapping("usersStorage")
    public String usersStorage(Model model) {
        List<Ownedcryptocurrencies> usersStorageCrypto = ownedcryptoRepo.findAll();
        model.addAttribute("usersStorageCrypto", usersStorageCrypto);
        List<Ownedstocks> usersStorageStocks = ownedstocksRepo.findAll();
        model.addAttribute("usersStorageStocks", usersStorageStocks);
        return "admin/storage/usersStorage";
    }

    @GetMapping("usersStorageCrypto")
    public String usersStorageCrypto(Model model) {
        List<Ownedcryptocurrencies> usersStorageCrypto = ownedcryptoRepo.findAll();
        model.addAttribute("usersStorageCrypto", usersStorageCrypto);
        return "admin/storage/usersStorageCrypto";
    }

    @GetMapping("usersStorageStocks")
    public String usersStorageStocks(Model model) {
        List<Ownedstocks> usersStorageStocks = ownedstocksRepo.findAll();
        model.addAttribute("usersStorageStocks", usersStorageStocks);
        return "admin/storage/usersStorageStocks";
    }

    @GetMapping("storageOfUsers/{id}")
    public String storageOfUsers(Model model, @PathVariable long id) {
        List<Ownedcryptocurrencies> usersStorageCrypto = ownedcryptoRepo.findUserByStorageId(id);
        List<Ownedstocks> usersStorageStocks = ownedstocksRepo.findUserByStorageId(id);

        if (usersStorageCrypto.isEmpty() && usersStorageStocks.isEmpty()) {
            model.addAttribute("error", "Nothing to display");
        }else{
            model.addAttribute("storageOfUsersCrypto", usersStorageCrypto);
            model.addAttribute("storageOfUsersStocks", usersStorageStocks);
        }
        return "admin/storage/storageOfUsers";
    }

    @GetMapping("storageOfUsersCrypto/{id}")
    public String storageOfUsersCrypto(Model model, @PathVariable long id) {
        List<Ownedcryptocurrencies> storageOfUsersCrypto = ownedcryptoRepo.findUserByStorageId(id);
        model.addAttribute("storageOfUsersCrypto", storageOfUsersCrypto);
        return "admin/storage/storageOfUsersCrypto";
    }

    @GetMapping("storageOfUsersStocks/{id}")
    public String storageOfUsersStocks(Model model, @PathVariable long id) {
        List<Ownedstocks> storageOfUsersStocks = ownedstocksRepo.findUserByStorageId(id);
        model.addAttribute("storageOfUsersStocks", storageOfUsersStocks);
        return "admin/storage/storageOfUsersStocks";
    }

    @GetMapping("/adminStorage/export/excel")
    public void adminStorageExportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=storage_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Storage> storage = storageRepository.findAll();

        AdminStorageExcelExporter excelExporter = new AdminStorageExcelExporter(storage);

        excelExporter.export(response);
    }

    @GetMapping("/adminStorageOfUsers/export/excel/{id}")
    public void adminStorageOfUsersExportToExcel(HttpServletResponse response, @PathVariable long id) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_storage_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Ownedcryptocurrencies> usersStorageCrypto = ownedcryptoRepo.findUserByStorageId(id);
        List<Ownedstocks> usersStorageStocks = ownedstocksRepo.findUserByStorageId(id);

        AdminStorageOfUsersExcelExporter excelExporter = new AdminStorageOfUsersExcelExporter(usersStorageCrypto, usersStorageStocks);

        excelExporter.export(response);
    }

    @GetMapping("/adminUsersStorage/export/excel")
    public void adminUsersStorageExportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_storage_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Ownedcryptocurrencies> usersStorageCrypto = ownedcryptoRepo.findAll();
        List<Ownedstocks> usersStorageStocks = ownedstocksRepo.findAll();

        AdminUsersStorageExcelExporter excelExporter = new AdminUsersStorageExcelExporter(usersStorageCrypto, usersStorageStocks);

        excelExporter.export(response);
    }

    @GetMapping("/adminUsersStorageCrypto/export/excel")
    public void adminUsersStorageCryptoExportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_storage_crypto_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Ownedcryptocurrencies> usersStorageCrypto = ownedcryptoRepo.findAll();

        AdminUsersStorageCryptoExcelExporter excelExporter = new AdminUsersStorageCryptoExcelExporter(usersStorageCrypto);

        excelExporter.export(response);
    }

    @GetMapping("/adminUsersStorageStocks/export/excel")
    public void adminUsersStorageStocksExportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_storage_stocks_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Ownedstocks> usersStorageStocks = ownedstocksRepo.findAll();

        AdminUsersStorageStocksExcelExporter excelExporter = new AdminUsersStorageStocksExcelExporter(usersStorageStocks);

        excelExporter.export(response);
    }
}
