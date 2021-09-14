package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findContactByUserId(long User);
}