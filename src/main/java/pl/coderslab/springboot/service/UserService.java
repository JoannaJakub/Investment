package pl.coderslab.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.springboot.model.User;

public interface UserService {
    User findByEmail(String email);
    User findByUserName(String name);
    void saveUser(User user);

    UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException;
}
