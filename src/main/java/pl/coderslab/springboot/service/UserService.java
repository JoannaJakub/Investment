package pl.coderslab.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByEmail(String email);
    User findByUserName(String name);
    void saveUser(User user);
    void delete(Long id);
    UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException;

    List<User> findByRoleId(long Roles);


    List<User> findAll();

}
