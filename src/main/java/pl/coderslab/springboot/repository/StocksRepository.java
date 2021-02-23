package pl.coderslab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Stocks;
import yahoofinance.Stock;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

public interface StocksRepository extends JpaRepository<Stocks, Long>  {
    @Modifying
    @Transactional
    @Query(nativeQuery=true, value="INSERT INTO stocks(price, change, currency, bid, name) values(?,?,?,?,?);")
    List<Stocks> saveStocks(BigDecimal currency, BigDecimal price, String change, BigDecimal bid, String name);


}
