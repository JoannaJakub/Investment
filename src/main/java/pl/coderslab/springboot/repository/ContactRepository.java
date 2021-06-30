package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Contact;
import pl.coderslab.springboot.model.Role;


public interface ContactRepository extends JpaRepository<Contact, Long> {
}