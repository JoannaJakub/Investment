package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findContactByUserId(long User);
}