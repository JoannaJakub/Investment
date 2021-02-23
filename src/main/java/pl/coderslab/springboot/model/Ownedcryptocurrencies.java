
package pl.coderslab.springboot.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Component
@RequiredArgsConstructor
public class Ownedcryptocurrencies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String symbol;
    private String slug;
    private String num_market_pairs;
    private String date_added;
    private Float circulating_supply;
    private Float total_supply;
    private Integer cmc_rank;
    private String last_updated;

    private Long start;
    private Long limit;
    private Double priceMin;
    private Double priceMax;
    private Double marketCapMin;
    private Double marketCapMax;
    private Double volume24hMin;
    private Double volume24hMax;
    private Double circulatingSupplyMin;
    private Double circulatingSupplyMax;
    private Double percentChange24hMin;
    private Double percentChange24hMax;
    private String convert;
    private String convertId;
    private String sort;
    private String sortDir;
    private String cryptocurrencyType;
    private String tag;
    private String aux;

    private Double howMuch;
    private Double numOfCoins;
    private Date whenBought;
    private String notes;


    @ManyToOne (cascade = CascadeType.ALL)
    private Storage storage;
    @ManyToOne (cascade = CascadeType.ALL)
    private User user;
    @ManyToOne (cascade = CascadeType.ALL)
    private Cryptocurrencies cryptocurrencies;
}

