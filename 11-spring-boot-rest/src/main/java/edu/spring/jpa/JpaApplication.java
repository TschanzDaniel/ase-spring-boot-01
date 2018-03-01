package edu.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * curl -X GET http://localhost:8080
 * 
 * http://localhost:8080/swagger-ui.html
 */
@SpringBootApplication
@EnableAutoConfiguration

public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
}
