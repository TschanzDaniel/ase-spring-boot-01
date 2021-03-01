package edu.spring.security.basic;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SecurityStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityStarterApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080 \n" +
                  "-> mit login: zhaw und password: hallovelo\n\n");
    }

}
