package edu.spring.liquibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpaLiquibaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaLiquibaseApplication.class, args);
	}

	@PostConstruct
	public void afterInit() {
		System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080 \n" +
				"http://localhost:8080/v3/api-docs\n" +
				"http://localhost:8080/swagger-ui.html \n" +
				"http://localhost:8080/h2-console  " + "" +
				"-> mit Generic H2 (Embedded), org.h2.Driver, jdbc:h2:mem:testdb / jdbc:h2:file:./database und sa \n\n");
	}
}
