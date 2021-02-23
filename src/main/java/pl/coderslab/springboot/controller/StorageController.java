package pl.coderslab.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.repository.StorageRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StorageController {
    @Autowired
    private StorageRepository storageRepository;


    @GetMapping("/storage")
    public String yourStorage(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        List<Storage> yourStorage = storageRepository.findById(entityUser);
        model.addAttribute("yourStorage", yourStorage);

        List<Storage> storage = storageRepository.findAll();
        model.addAttribute("storage", storage);


        return "storage";
    }
    @GetMapping("/addStorage")
    public String addStorage(Model model) {
        model.addAttribute("storage", new Storage());
        return "addStorage";
    }


    @RequestMapping(value = "/storageSuccess", method = RequestMethod.POST)
    public String processAddingStorage(@Valid Storage storage, BindingResult result) {
        if (result.hasErrors()) {
            return "addStorage";
        } else {
            storageRepository.save(storage);
            return "storageSuccess";
        }
    }
}
