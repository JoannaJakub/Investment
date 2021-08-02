package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface OwnedstocksRepository extends JpaRepository<Ownedstocks, Long> {
    @Query(nativeQuery = true, value = "SELECT *FROM ownedstocks LEFT JOIN user on ownedstocks.user_id=user.id where username=?;")
    List<Ownedstocks> findById(String entityUser);

    List<Ownedstocks> findByUser(User user);

    Set<Ownedstocks> findStorageByUser(User user);

    List<Ownedstocks> findInvestByUser(Optional<User> user);

    List<Ownedstocks> findUserByStocksId(Long id);

    List<Ownedstocks> findUserByStorageId(Long id);


}