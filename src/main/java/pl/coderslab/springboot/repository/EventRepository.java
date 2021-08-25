package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springboot.model.Event;


public interface EventRepository extends JpaRepository<Event, Long> {

}