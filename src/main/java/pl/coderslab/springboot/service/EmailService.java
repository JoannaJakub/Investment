package pl.coderslab.springboot.service;

import pl.coderslab.springboot.model.Mail;


public interface EmailService {
    void send(Mail mail);
}
