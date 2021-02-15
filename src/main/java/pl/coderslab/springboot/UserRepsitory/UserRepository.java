package pl.coderslab.springboot.UserRepsitory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    /*@Query("SELECT u FROM Users u WHERE u.email = ?1")
    public Users findByEmail(String email);*/
}
