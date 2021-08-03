package pl.coderslab.springboot.implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.springboot.model.PasswordResetToken;
import pl.coderslab.springboot.model.Role;
import pl.coderslab.springboot.model.User;
import pl.coderslab.springboot.repository.PasswordResetTokenDAO;
import pl.coderslab.springboot.service.PasswordResetTokenService;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    private final PasswordResetTokenDAO passwordResetTokenDAO;

    public PasswordResetTokenServiceImpl(PasswordResetTokenDAO passwordResetTokenDAO) {
        this.passwordResetTokenDAO = passwordResetTokenDAO;
    }

    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenDAO.findByToken(token).orElse(null);
    }

    @Override
    public PasswordResetToken save(PasswordResetToken passwordResetToken) {
        return passwordResetTokenDAO.save(passwordResetToken);
    }

}