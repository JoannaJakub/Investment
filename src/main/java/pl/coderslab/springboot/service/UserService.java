package pl.coderslab.springboot.service;

import pl.coderslab.springboot.model.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);

    User findByUserName(String name);

    void saveUser(User user);

    void delete(Long id);


    List<User> findAll();

    User save(User user);

}
