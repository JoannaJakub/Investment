package pl.coderslab.springboot.repository;

import pl.coderslab.springboot.model.User;

public interface UserService {
    User findByEmail(String email);

}
