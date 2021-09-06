package pl.coderslab.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Contact;
import pl.coderslab.springboot.repository.ContactRepository;

import javax.validation.Valid;
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
        return "admin/contact/adminContactConfirmDelete";
    }

    @GetMapping(value = {"/adminContactDelete/{id}"})
    public String adminContactDelete(@PathVariable long id) {
        contactRepository.deleteById(id);
        return "redirect:/adminContact";
    }

    @GetMapping(value = {"/adminContactEdit/{id}"})
    public String adminContactEditForm(@PathVariable long id, Model model) {
        model.addAttribute("adminContactEdit", contactRepository.findById(id));
        return "admin/contact/adminContactEdit";
    }

    @PostMapping(value = {"adminContactEdit/{id}"})
    public String adminContactEditSave(@Valid Contact contact) {
        contactRepository.save(contact);
        return "redirect:/adminContactConfirmEditing/{id}";
    }

    @RequestMapping("/adminContactConfirmEditing/{id}")
    public String adminContactConfirmEditing(@PathVariable long id, Model model) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            model.addAttribute("adminContactConfirmEdit", contact.get());
        } else {
            return "admin/adminError";
        }
        return "admin/contact/adminContactConfirmEdit";
    }

    @GetMapping(value = {"/adminContactDetails/{id}"})
    public String adminContactDetails(@PathVariable long id, Model model) {
        Optional<Contact> contactDetails = contactRepository.findById(id);
        if (contactDetails.isPresent()) {
            model.addAttribute("adminContactDetails", contactDetails.get());
        } else {
            return "admin/adminError";
        }
        return "admin/contact/adminContactDetails";
    }

    @GetMapping("adminContactHeader")
    public String adminContactHeader(Model model) {
        List<Contact> contact = contactRepository.findAll();
        model.addAttribute("adminContactHeader", contact);
        return "admin/adminDashboard";
    }
}

