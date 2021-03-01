package edu.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 *
 * curl -X GET http://localhost:8080
 *
 * http://localhost:8080/swagger-ui.html
 */
@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@PostConstruct
	public void afterInit() {
		System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080 \n" +
				"http://localhost:8080/v3/api-docs\n" +
				"http://localhost:8080/swagger-ui.html \n" +
				"http://localhost:8080/h2-console  " + "" +
				"-> mit Generic H2 (Embedded), org.h2.Driver, jdbc:h2:mem:testdb und sa \n\n");
	}
}
