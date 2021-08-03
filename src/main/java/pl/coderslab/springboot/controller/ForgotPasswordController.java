package pl.coderslab.springboot.controller;


import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.springboot.model.Mail;
import pl.coderslab.springboot.model.PasswordResetToken;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.repository.PasswordForgot;
import pl.coderslab.springboot.repository.StocksRepository;
import pl.coderslab.springboot.service.EmailService;
import pl.coderslab.springboot.service.PasswordResetTokenService;
import pl.coderslab.springboot.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
@Controller
public class ForgotPasswordController {
    private final StocksRepository stocksRepository;
    private final CryptocurrencyRepository cryptocurrencyRepo;
    private final UserService userService;
    private final MessageSource messageSource;
    private final PasswordResetTokenService passwordResetTokenService;
    private final EmailService emailService;

    public ForgotPasswordController(StocksRepository stocksRepository,
                                    CryptocurrencyRepository cryptocurrencyRepo,
                                    UserService userService,
                                    MessageSource messageSource,
                                    PasswordResetTokenService passwordResetTokenService,
                                    EmailService emailService) {
        this.stocksRepository = stocksRepository;
        this.cryptocurrencyRepo = cryptocurrencyRepo;
        this.userService = userService;
        this.messageSource = messageSource;
        this.passwordResetTokenService = passwordResetTokenService;
        this.emailService = emailService;
    }


    @GetMapping
    public String viewPage(){
        return "forgot-password";
    }
    @PostMapping
    public String processPasswordForgot(@Valid @ModelAttribute("passwordForgot") PasswordForgot passwordForgot,
                                        BindingResult result,
                                        Model model,
                                        RedirectAttributes attributes,
                                        HttpServletRequest request){
        if(result.hasErrors()){
            return "forgot-password";
        }
        User user = userService.findByEmail(passwordForgot.getEmail());
        if(user == null){
            model.addAttribute("emailError", messageSource.getMessage("EMAIL_NOT_FOUND", new Object[]{}, Locale.ENGLISH));
            return "forgot-password";
        }
        // proceed to send email with link to reset password to this email address
        PasswordResetToken token = new PasswordResetToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpirationDate(LocalDateTime.now().plusMinutes(30));
        token = passwordResetTokenService.save(token);
        if(token == null){
            model.addAttribute("tokenError", messageSource.getMessage("TOKEN_NOT_SAVED", new Object[]{}, Locale.ENGLISH));
            return "forgot-password";
        }
        Mail mail = new Mail();
        mail.setFrom("no-reply@mohyehia.com");
        mail.setTo(user.getUsername());
        mail.setSubject("Password reset request");

        Map<String, Object> mailModel = new HashMap<>();
        mailModel.put("token", token);
        mailModel.put("user", user);
        mailModel.put("signature", "http://mohyehia.com");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        mailModel.put("resetUrl", url + "/reset-password?token=" + token.getToken());
        mail.setModel(mailModel);
        /* send email using emailService
        if email sent successfully redirect with flash attributes
         */
        emailService.send(mail);
        attributes.addFlashAttribute("success", messageSource.getMessage("PASSWORD_RESET_TOKEN_SENT", new Object[]{}, Locale.ENGLISH));
        return "redirect:/forgot-password";
    }

    @ModelAttribute("passwordForgot")
    public PasswordForgot passwordForgot(){
        return new PasswordForgot();
    }

}
