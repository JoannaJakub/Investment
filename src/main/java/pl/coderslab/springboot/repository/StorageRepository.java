package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springboot.model.Storage;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Long> {

    @Query(nativeQuery=true, value="SELECT *FROM storage LEFT JOIN user on storage.user_id=user.id where username=?;")
    List<Storage> findById(String entityUser);


}
