package pl.coderslab.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Data
@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Messanger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Proszę wpisać wiadomość")
    private String message;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    @ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private User user;
}