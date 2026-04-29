/*
 * SecurityConfig.java
 * SpringBoot Security Configuration.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 09 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("admin1234"))
                .roles("ADMIN")
                .and()
                .withUser("lema")
                .password(encoder().encode("lema1234"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //TODO add more http methods

        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "**/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "**/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "**/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/getall").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/getall").hasRole("USER")
                .antMatchers(HttpMethod.GET, "**/read/{id}").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
