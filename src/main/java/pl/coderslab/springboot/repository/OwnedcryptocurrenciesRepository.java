package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.User;

import java.util.List;
import java.util.Optional;


public interface OwnedcryptocurrenciesRepository extends JpaRepository<Ownedcryptocurrencies, Long> {
    @Query(nativeQuery = true, value = "SELECT *FROM ownedcryptocurrencies LEFT JOIN user on ownedcryptocurrencies.user_id=user.id where username=?;")
    List<Ownedcryptocurrencies> findById(String entityUser);

    List<Ownedcryptocurrencies> findByUser(User user);

    List<Ownedcryptocurrencies> findInvestByUser(Optional<User> user);

    List<Ownedcryptocurrencies> findUserByCryptocurrenciesId(Long id);

    List<Ownedcryptocurrencies> findUserByStorageId(Long id);


}