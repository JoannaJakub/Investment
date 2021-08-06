package pl.coderslab.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.User;

import java.util.Optional;
import java.util.Set;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Set<User> findAllByRoleId(long id);
   // Optional<User> findUsersByRoleId(long id);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserslByRoleId(long id);
}
