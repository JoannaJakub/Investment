package pl.coderslab.springboot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.springboot.model.Cryptocurrencies;
import pl.coderslab.springboot.repository.CryptocurrencyRepository;
import pl.coderslab.springboot.service.CryptocurrencyService;
import pl.coderslab.springboot.service.CustomUserDetailsService;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;


    @Bean
    public UserDetailsService userDetailsService() {return new CustomUserDetailsService();  }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
              .antMatchers("/dashboard").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/dashboard")

                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
    }
// .failureUrl("/login-error")


    @Resource
    private CryptocurrencyRepository cryptocurrencyRepository;
    private CryptocurrencyService cryptocurrencyService;


 /*   @Bean
    CommandLineRunner runner(CryptocurrencyService cryptocurrencyService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Cryptocurrencies>> typeReference = new TypeReference<List<Cryptocurrencies>>() {
            };

            InputStream inputStream = TypeReference.class.getResourceAsStream("/crypto");

            try {
                List<Cryptocurrencies> cryptocurrencies = mapper.readValue(inputStream, typeReference);
                cryptocurrencyService.save(cryptocurrencies);
                System.out.println("Cryp Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save crypto: " + e.getMessage());
            }
        };
    }*/
}