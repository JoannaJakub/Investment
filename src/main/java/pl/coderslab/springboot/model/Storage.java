package pl.coderslab.springboot.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please enter name.")
    private String name;
    @NotBlank(message = "Please enter link.")
    private String link;

}
