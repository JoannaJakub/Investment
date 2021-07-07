package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.repository.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminStorageController {
    private final StorageRepository storageRepository;

    public AdminStorageController( StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
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

    @GetMapping(value = {"/storageDetails/{id}"})
    public String storageDetails(@PathVariable long id, Model model) {
        Optional<Storage> storageDetails = storageRepository.findById(id);
        if (storageDetails.isPresent()) {
            model.addAttribute("storageDetails", storageDetails.get());
        }
        else{ return "admin/adminError";}
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
        List<Storage> usersStorage = storageRepository.findUsersStorageByUser();
        model.addAttribute("usersStorage", usersStorage);
        return "admin/storage/usersStorage";
    }

}
