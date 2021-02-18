package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.User;

import java.util.List;


public interface OwnedcryptocurrenciesRepository extends JpaRepository<Ownedcryptocurrencies, Long> {
    User findByUserId(String id);
    @Query(nativeQuery=true, value="SELECT *  FROM ownedcryptocurrencies WHERE user_id=19;")
    List<Ownedcryptocurrencies> findAllByUser(User id);
}