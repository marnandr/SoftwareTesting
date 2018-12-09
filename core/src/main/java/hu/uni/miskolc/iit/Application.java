package hu.uni.miskolc.iit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Launch the application
        SpringApplication.run(Application.class, args);
    }
}
