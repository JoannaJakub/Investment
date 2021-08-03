package pl.coderslab.springboot.service;

import org.springframework.context.annotation.Bean;
import pl.coderslab.springboot.model.Mail;
import pl.coderslab.springboot.model.PasswordResetToken;


public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);
    PasswordResetToken save(PasswordResetToken passwordResetToken);}
