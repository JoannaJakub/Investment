package pl.coderslab.springboot.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Component
@RequiredArgsConstructor
public class Ownedstocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter how much did you paid.")
    private Double howMuch;
    @NotNull(message = "Please enter how many stocks did you bought.")
    private Double numOfCoins;
    @NotNull(message = "Please enter when did you bought stocks in format YEAR-MONTH-DATE.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate whenBought;

    private String notes;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Storage storage;
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;
    @ManyToOne  (fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Stocks stocks;
}


