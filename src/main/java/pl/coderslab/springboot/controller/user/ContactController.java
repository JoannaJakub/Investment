package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Message;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.MessageRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {
    private final UserService userService;
    private final MessageRepository messageRepository;

    public ContactController(UserService userService, MessageRepository messageRepository) {
        this.userService = userService;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/yourContact")
    public String yourContact(Model model, Authentication authentication) {
        User user = userService.findByUserName(authentication.getName());
        List<Message> contact = messageRepository.findContactByUserId(user.getId());
        if (contact.isEmpty()) {
            model.addAttribute("error", "Nothing to display");
        } else {
            model.addAttribute("contact", contact);

        }
        return "user/contact/contact";
    }

    @GetMapping("/addContact")
    public String addContact(Model model,Authentication authentication) {
        model.addAttribute("contact", new Message());
        model.addAttribute("user", userService.findByUserName(authentication.getName()));
        return "user/contact/addContact";
    }

    @PostMapping(value = "/contactSuccess")
    public String processAddingContact(@Valid Message contact, BindingResult result) {
        if (result.hasErrors()) {
            return "user/contact/addContact";
        } else {
            messageRepository.save(contact);
            return "user/contact/contactSuccess";
        }
    }

    @RequestMapping("/contactConfirmDelete")
    public String contactConfirmDelete() {
        return "user/contact/contactConfirmDelete";
    }

    @GetMapping(value = {"/contactDelete/{id}"})
    public String contactDelete(@PathVariable long id) {
        messageRepository.deleteById(id);
        return "redirect:/yourContact";
    }

    @GetMapping(value = {"/contactDetails/{id}"})
    public String contactDetails(@PathVariable long id, Model model) {
        Optional<Message> contactDetails = messageRepository.findById(id);
        if (contactDetails.isPresent()) {
            model.addAttribute("contactDetails", contactDetails.get());
        }
        else{ return "user/userError";}

        return "user/contact/contactDetails";
    }

    @GetMapping(value = {"/contactEdit/{id}"})
    public String contactEditForm(@PathVariable long id, Model model) {
        model.addAttribute("contactEdit", messageRepository.findById(id));
        return "user/contact/contactEdit";
    }

    @PostMapping(value = {"contactEdit/{id}"})
    public String contactEditSave(@Valid Message contact) {
        messageRepository.save(contact);
        return "redirect:/contactConfirmEditing/{id}";
    }

    @RequestMapping("/contactConfirmEditing/{id}")
    public String contactConfirmEditing(@PathVariable long id, Model model) {
        Optional<Message> contact = messageRepository.findById(id);
        if (contact.isPresent()) {
            model.addAttribute("contactConfirmEdit", contact.get());
        } else {
            return "user/userError";
        }
        return "user/contact/contactConfirmEdit";
    }

}
