package edu.spring.flyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * http://localhost:8080/h2-console

 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
}


