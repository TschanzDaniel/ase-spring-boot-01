package edu.spring.security.custom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SecurityCustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityCustomApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080 \n" );
    }
}
