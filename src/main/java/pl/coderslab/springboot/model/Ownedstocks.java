package pl.coderslab.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@Component
@RequiredArgsConstructor
public class Ownedstocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull
    private Double howMuch;
    @NotNull
    private Double numOfCoins;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate whenBought;

    private String notes;

    @ManyToOne
           // (fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Storage storage;
    @ManyToOne
         //   (fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;
    @ManyToOne
        //    (fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Stocks stocks;
}


