package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Cryptocurrencies;

public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrencies, Long> {
}
