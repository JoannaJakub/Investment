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

    @Query(nativeQuery = true, value = "SELECT * FROM ownedcryptocurrencies\n" +
            "    LEFT JOIN cryptocurrencies on  ownedcryptocurrencies.cryptocurrencies_id=cryptocurrencies_id\n" +
            "    left JOIN user on ownedcryptocurrencies.user_id=user.id where user.username=?;")
    List<Ownedcryptocurrencies> findByUser(User user);

    List<Ownedcryptocurrencies> findInvestByUser(Optional<User> user);
    //@Query(nativeQuery = true, value = "SELECT user_id FROM ownedcryptocurrencies WHERE storage_id=?;")
  //  List<User> findUserByStorageId(Long id);
    List<Ownedcryptocurrencies> findUserByCryptocurrenciesId(Long id);

}