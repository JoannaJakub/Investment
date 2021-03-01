package pl.coderslab.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import pl.coderslab.springboot.model.Stocks;

public class StockApi {

    private final String INSERT_SQL = "INSERT INTO stocks(name, price, change) values(?,?,?)";
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Stocks create (Stocks stocks) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", stocks.getName())
                .addValue("price", stocks.getPrice())
                .addValue("change", stocks.getChange());
        namedParameterJdbcTemplate.update(INSERT_SQL, parameters);
        System.out.println("=======" + stocks);
        return stocks;
    }
}




