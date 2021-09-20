package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Messanger;

import java.util.List;

public interface MessageRepository extends JpaRepository<Messanger, Long> {
    List<Messanger> findMessageByUserId(long User);
}