package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Storage;


public interface StorageRepository extends JpaRepository<Storage, Long> {
}
