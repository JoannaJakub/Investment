package pl.coderslab.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.model.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


}
