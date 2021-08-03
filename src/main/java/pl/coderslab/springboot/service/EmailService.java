package pl.coderslab.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.springboot.model.Mail;
import pl.coderslab.springboot.model.User;

import java.util.List;

public interface EmailService {
    void send(Mail mail);
}
