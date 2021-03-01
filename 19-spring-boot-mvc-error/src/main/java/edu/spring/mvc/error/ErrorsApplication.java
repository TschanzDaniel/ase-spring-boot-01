package edu.spring.mvc.error;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ErrorsApplication {


    public static void main(String[] args) {
        SpringApplication.run(ErrorsApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080/posts/ \n" +
                "http://localhost:8080/posts/get/ \n" +
                "http://localhost:8080/posts/get/bla \n" +
                "http://localhost:8080/error \n" +
                "http://localhost:8080/404 \n" +
                "" );
    }

}
