package pl.coderslab.springboot.service;

import pl.coderslab.springboot.model.User;

public interface UserService {
    User findByEmail(String email);
    User findByUserName(String name);

    void saveUser(User user);

}
