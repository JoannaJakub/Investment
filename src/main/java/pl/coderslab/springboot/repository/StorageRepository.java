package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Storage;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Long> {

}
