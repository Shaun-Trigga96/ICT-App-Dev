/*
 * LabBookingApplication.java
 * SpringBoot Application.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 09 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

//@EnableAdminServer
@SpringBootApplication
public class LabBookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(LabBookingApplication.class, args);
    }

}
