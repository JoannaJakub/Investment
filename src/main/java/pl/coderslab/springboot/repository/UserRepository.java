package pl.coderslab.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Role;
import pl.coderslab.springboot.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery=true, value="SELECT id FROM user  WHERE username =?;")
    User findIdByUsername(String username);
    User findByUsername(String username);


}
