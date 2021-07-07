package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Storage;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Long> {
    @Query(nativeQuery=true, value="SELECT * FROM user_storage LEFT JOIN storage ON user_storage.storage_id = storage.id;")
    List<Storage> findUsersStorageByUser();
}
