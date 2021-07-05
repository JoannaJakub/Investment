package pl.coderslab.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Contact;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminContactController {
    private final ContactRepository contactRepository;

    public AdminContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("adminContact")
    public String adminContact(Model model) {
        List<Contact> contact = contactRepository.findAll();
        model.addAttribute("adminContact", contact);
        return "admin/contact/adminContact";
    }
    @RequestMapping("/adminContactConfirmDelete")
    public String adminContactConfirmDelete() {
        return "admin/contact/contactConfirmDelete";
    }

    @GetMapping(value = {"/adminContactDelete/{id}"})
    public String adminContactDelete(@PathVariable long id) {
        contactRepository.deleteById(id);
        return "redirect:/adminContact";
    }
}

