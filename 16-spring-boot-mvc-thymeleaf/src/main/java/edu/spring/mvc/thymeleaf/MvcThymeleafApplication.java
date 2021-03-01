package edu.spring.mvc.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MvcThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcThymeleafApplication.class, args);
	}

	@PostConstruct
	public void afterInit() {
		System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080 \n" +
				"http://localhost:8080/customers  " + "\n" +
				"http://localhost:8080/home  " + "\n" +
				"http://localhost:8080/home/method0  " + "\n" +
				"For more examples... check the file home-controller-test.sh " + "\n" +
				"http://localhost:8080/h2-console  " + "" +
				"-> mit Generic H2 (Embedded), org.h2.Driver, jdbc:h2:mem:testdb / jdbc:h2:file:./database und sa \n\n");
	}

}
