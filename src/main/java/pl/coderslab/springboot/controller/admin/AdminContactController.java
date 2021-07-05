package pl.coderslab.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springboot.model.Contact;
import pl.coderslab.springboot.repository.ContactRepository;

import java.util.List;

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

}

