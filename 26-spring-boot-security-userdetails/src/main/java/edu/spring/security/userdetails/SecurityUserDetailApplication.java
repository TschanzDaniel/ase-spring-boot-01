package edu.spring.security.userdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SecurityUserDetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityUserDetailApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080 \n" +
                "http://localhost:8080/h2-console  " + "" +
                "-> mit Generic H2 (Embedded), org.h2.Driver, jdbc:h2:mem:testdb / jdbc:h2:file:./database und sa \n\n");
    }
}
