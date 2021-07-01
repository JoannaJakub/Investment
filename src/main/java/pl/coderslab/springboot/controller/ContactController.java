package pl.coderslab.springboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Contact;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.ContactRepository;
import pl.coderslab.springboot.repository.StorageRepository;
import pl.coderslab.springboot.repository.UserRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/yourContact")
    public String yourContact(Model model, Authentication authentication) {
        User user = userService.findByUserName(authentication.getName());
        List<Contact> contact = contactRepository.findContactByUserId(user.getId());
        if (!contact.isEmpty()) {
            model.addAttribute("contact", contact);
        } else {
            return "user/userError";
        }
        return "user/contact/contact";
    }


    @GetMapping("/addContact")
    public String addContact(Model model,Authentication authentication) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("user", userService.findByUserName(authentication.getName()));
        return "user/contact/addContact";
    }


    @PostMapping(value = "/contactSuccess")
    public String processAddingContact(@Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "user/contact/addContact";
        } else {
            contactRepository.save(contact);
            return "user/contact/contactSuccess";
        }
    }
    @RequestMapping("/contactConfirmDelete")
    public String contactConfirmDelete() {
        return "user/contact/contactConfirmDelete";
    }

    @GetMapping(value = {"/contactDelete/{id}"})
    public String contactDelete(@PathVariable long id) {
        contactRepository.deleteById(id);
        return "redirect:/yourContact";
    }
    @GetMapping(value = {"/contactDetails/{id}"})
    public String contactDetails(@PathVariable long id, Model model) {
        Optional<Contact> contactDetails = contactRepository.findById(id);
        if (contactDetails.isPresent()) {
            model.addAttribute("contactDetails", contactDetails.get());
        }
        else{ return "user/userError";}

        return "user/contact/contactDetails";
    }
}
