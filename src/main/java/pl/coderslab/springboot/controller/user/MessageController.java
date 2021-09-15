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
public class MessageController {
    private final UserService userService;
    private final MessageRepository messageRepository;

    public MessageController(UserService userService, MessageRepository messageRepository) {
        this.userService = userService;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/yourMessage")
    public String yourContact(Model model, Authentication authentication) {
        User user = userService.findByUserName(authentication.getName());
        List<Message> message = messageRepository.findMessageByUserId(user.getId());
        if (message.isEmpty()) {
            model.addAttribute("error", "Nothing to display");
        } else {
            model.addAttribute("message", message);

        }
        return "user/message/message";
    }

    @GetMapping("/addMessage")
    public String addMessage(Model model,Authentication authentication) {
        model.addAttribute("message", new Message());
        model.addAttribute("user", userService.findByUserName(authentication.getName()));
        return "user/message/addMessage";
    }

    @PostMapping(value = "/messageSuccess")
    public String processAddingMessage(@Valid Message message, BindingResult result) {
        if (result.hasErrors()) {
            return "user/message/addMessage";
        } else {
            messageRepository.save(message);
            return "user/message/messageSuccess";
        }
    }

    @RequestMapping("/messageConfirmDelete")
    public String MessageConfirmDelete() {
        return "user/message/messageConfirmDelete";
    }

    @GetMapping(value = {"/messageDelete/{id}"})
    public String messageDelete(@PathVariable long id) {
        messageRepository.deleteById(id);
        return "redirect:/yourMessage";
    }

    @GetMapping(value = {"/MessageDetails/{id}"})
    public String messageDetails(@PathVariable long id, Model model) {
        Optional<Message> messageDetails = messageRepository.findById(id);
        if (messageDetails.isPresent()) {
            model.addAttribute("messageDetails", messageDetails.get());
        }
        else{ return "user/userError";}

        return "user/message/messageDetails";
    }

    @GetMapping(value = {"/messageEdit/{id}"})
    public String messageEditForm(@PathVariable long id, Model model) {
        model.addAttribute("messageEdit", messageRepository.findById(id));
        return "user/message/messageEdit";
    }

    @PostMapping(value = {"MessageEdit/{id}"})
    public String MessageEditSave(@Valid Message Message) {
        messageRepository.save(Message);
        return "redirect:/messageConfirmEditing/{id}";
    }

    @RequestMapping("/messageConfirmEditing/{id}")
    public String messageConfirmEditing(@PathVariable long id, Model model) {
        Optional<Message> message = messageRepository.findById(id);
        if (message.isPresent()) {
            model.addAttribute("messageConfirmEdit", message.get());
        } else {
            return "user/userError";
        }
        return "user/message/messageConfirmEdit";
    }

}
