package pl.coderslab.springboot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.springboot.service.CustomUserDetailsService;
import pl.coderslab.springboot.service.SpringDataUserDetailsService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {return new CustomUserDetailsService();  }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

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
              .antMatchers("/dashboard", "/yourStocks", "/yourCrypto", "/storage", "/allStocks", "/allCrypto", "/addCrypto","/addStocks", "/cryptoSuccess", "/stocksSuccess")
                .authenticated()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username")
                .defaultSuccessUrl("/dashboard")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .deleteCookies("JSESSIONID");
    }
}