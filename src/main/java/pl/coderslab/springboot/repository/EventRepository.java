package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Contact;
import pl.coderslab.springboot.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

}