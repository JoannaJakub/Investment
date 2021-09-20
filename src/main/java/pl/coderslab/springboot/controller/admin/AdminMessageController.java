package pl.coderslab.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Messanger;
import pl.coderslab.springboot.repository.MessageRepository;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminMessageController {
    private final MessageRepository messageRepository;
    private final UserService userService;

    public AdminMessageController(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    @GetMapping("adminMessage")
    public String adminMessage(Model model) {
        List<Messanger> messanger = messageRepository.findAll();
        if (messanger.isEmpty()) {
            model.addAttribute("error", "Nothing to display");
        } else {
            model.addAttribute("adminMessage", messanger);
        }
        return "admin/message/adminMessage";
    }

    @RequestMapping("/adminMessageConfirmDelete")
    public String adminMessageConfirmDelete() {
        return "admin/message/adminMessageConfirmDelete";
    }

    @GetMapping(value = {"/adminMessageDelete/{id}"})
    public String adminMessageDelete(@PathVariable long id) {
        messageRepository.deleteById(id);
        return "redirect:/adminMessage";
    }

    @GetMapping(value = {"/adminMessageEdit/{id}"})
    public String adminMessageEditForm(@PathVariable long id, Model model) {
        model.addAttribute("adminMessageEdit", messageRepository.findById(id));
        model.addAttribute("user", userService.findAll());
        return "admin/message/adminMessageEdit";
    }

    @PostMapping(value = {"adminMessageEdit/{id}"})
    public String adminMessageEditSave(@Valid Messanger messanger) {
        messageRepository.save(messanger);
        return "redirect:/adminMessageConfirmEditing/{id}";
    }

    @RequestMapping("/adminMessageConfirmEditing/{id}")
    public String adminMessageConfirmEditing(@PathVariable long id, Model model) {
        Optional<Messanger> message = messageRepository.findById(id);
        if (message.isPresent()) {
            model.addAttribute("adminMessageConfirmEdit", message.get());
        } else {
            return "admin/adminError";
        }
        return "admin/message/adminMessageConfirmEdit";
    }

    @GetMapping(value = {"/adminMessageDetails/{id}"})
    public String adminMessageDetails(@PathVariable long id, Model model) {
        Optional<Messanger> messageDetails = messageRepository.findById(id);
        if (messageDetails.isPresent()) {
            model.addAttribute("adminMessageDetails", messageDetails.get());
        } else {
            return "admin/adminError";
        }
        return "admin/message/adminMessageDetails";
    }

    @GetMapping("/adminSendMessage")
    public String adminSendMessage(Model model ){
        model.addAttribute("message", new Messanger());
        model.addAttribute("user", userService.findAll());
        return "admin/message/adminSendMessage";
    }

    @PostMapping(value = "/adminSendMessageSuccess")
    public String adminSendMessageSuccess(@Valid Messanger messanger, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/message/adminSendMessage";
        } else {
            messageRepository.save(messanger);
            return "admin/message/adminSendMessageSuccess";
        }
    }
}

