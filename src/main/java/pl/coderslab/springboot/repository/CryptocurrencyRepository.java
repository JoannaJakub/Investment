package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Cryptocurrencies;


import java.util.List;

public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrencies, Long> {
    @Query(nativeQuery=true, value="SELECT *  FROM cryptocurrencies ORDER BY RAND() LIMIT 10;")
    List<Cryptocurrencies> find10All();
    List<Cryptocurrencies> findAll();


}
