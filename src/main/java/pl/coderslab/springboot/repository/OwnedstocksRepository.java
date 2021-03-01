package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.User;

import java.util.List;


public interface OwnedstocksRepository extends JpaRepository<Ownedstocks, Long> {
    @Query(nativeQuery = true, value = "SELECT *FROM ownedstocks LEFT JOIN user on ownedstocks.user_id=user.id where username=?;")
    List<Ownedstocks> findById(String entityUser);

    @Query(nativeQuery = true, value = "SELECT * FROM ownedstocks\n" +
            "                  left JOIN user on ownedstocks.user_id=user.id\n" +
            "                  left JOIN stocks on  ownedstocks.stocks_id=stocks_id\n" +
            "                   where user.username=?")
    List<Ownedstocks> findSomeById(String entityUser);

    List<Ownedstocks> findByUser(User user);

    @Query(nativeQuery = true, value = "SELECT id FROM user where username=?;")
    Ownedstocks findUserById(String entityUser);

}