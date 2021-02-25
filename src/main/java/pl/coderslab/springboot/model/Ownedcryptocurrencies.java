
package pl.coderslab.springboot.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@Component
@RequiredArgsConstructor
public class Ownedcryptocurrencies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter how much did you paid.")
    private Double howMuch;
    @NotNull(message = "Please enter how many crypto did you bought.")
    private Double numOfCoins;
    @NotNull(message = "Please enter when did you bought crypto in format YEAR-MONTH-DATE.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate whenBought;

    private String notes;


    @ManyToOne (cascade = CascadeType.ALL)
    private Storage storage;
    @ManyToOne (cascade = CascadeType.ALL)
    private User user;
    @ManyToOne (cascade = CascadeType.ALL)
    private Cryptocurrencies cryptocurrencies;
}

