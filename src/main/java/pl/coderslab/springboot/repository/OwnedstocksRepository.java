package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;

import java.util.List;


public interface OwnedstocksRepository extends JpaRepository<Ownedstocks, Long> {
//@Query(nativeQuery=true, value="SELECT user_id  FROM ownedcryptocurrencies JOIN user where username=?;")
@Query(nativeQuery=true, value="SELECT *FROM ownedstocks LEFT JOIN user on ownedstocks.user_id=user.id where username=?;")
List<Ownedstocks> findById(String entityUser);
}