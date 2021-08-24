package pl.coderslab.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springboot.model.Event;
import pl.coderslab.springboot.repository.EventRepository;

import java.util.List;


@Controller
public class AdminCalendar {

    private final EventRepository eventRepository;

    public AdminCalendar(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("adminCalendar")
    public String adminDashboard(Model model) {

        List<Event> event = eventRepository.findAll();
        model.addAttribute("event", event);
        return "admin/calendar/adminCalendar";
    }

}

