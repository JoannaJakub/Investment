package pl.coderslab.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.springboot.model.Contact;
import pl.coderslab.springboot.repository.ContactRepository;
import pl.coderslab.springboot.repository.StorageRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;

@Controller
public class ContactController {
    private final StorageRepository storageRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ContactRepository contactRepository;

    public ContactController(StorageRepository storageRepository, UserRepository userRepository, UserService userService, ContactRepository contactRepository) {
        this.storageRepository = storageRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.contactRepository = contactRepository;
    }

    @GetMapping("/addContact")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "user/contact/addContact";
    }


    @PostMapping(value = "/contactSuccess")
    public String processAddingContact(@Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "user/storage/addContact";
        } else {
            contactRepository.save(contact);
            return "user/storage/storageSuccess";
        }
    }
}