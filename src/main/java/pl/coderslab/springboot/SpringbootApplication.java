package pl.coderslab.springboot;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.coderslab.springboot.controller.CryptocurrencyController;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.service.CryptocurrencyService;


import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }


}

