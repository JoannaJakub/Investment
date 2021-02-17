
package pl.coderslab.springboot.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Component
@RequiredArgsConstructor
public class Ownedcryptocurrencies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private Float change;
    private Float cap;
    private Float vol;
    @ManyToOne
    private Storage storage;
    @ManyToOne
    private User user;
    @ManyToOne
    private Cryptocurrencies cryptocurrencies;
}

