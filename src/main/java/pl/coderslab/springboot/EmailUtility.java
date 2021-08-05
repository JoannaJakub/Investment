package pl.coderslab.springboot;

import org.apache.commons.lang3.RandomStringUtils;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.service.UserService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class EmailUtility {

    private final UserService userService;

    public EmailUtility(UserService userService) {
        this.userService = userService;
    }

    public static void sendEmail(String host, String port,
                                 final String senderEmail, String senderName, final String password,
                                 String recipientEmail, String subject, String message) throws AddressException,
            MessagingException, UnsupportedEncodingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(senderEmail, senderName));
        InternetAddress[] toAddresses = { new InternetAddress(recipientEmail) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);

        // sends the e-mail
        Transport.send(msg);

    }

    public String resetCustomerPassword(String username) {
        User customer = userService.findByUserName(username);

        String randomPassword = RandomStringUtils.randomAlphanumeric(10);

        customer.setPassword(randomPassword);
        userService.saveUser(customer);

        return randomPassword;
    }


}