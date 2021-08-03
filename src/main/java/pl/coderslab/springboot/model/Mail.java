package pl.coderslab.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;


@Data
public class Mail {
    private String from;
    private String to;
    private String subject;
    private Map<String, Object> model;
}