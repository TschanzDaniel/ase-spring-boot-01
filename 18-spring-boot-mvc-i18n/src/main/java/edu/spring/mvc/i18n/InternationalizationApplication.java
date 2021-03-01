package edu.spring.mvc.i18n;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class InternationalizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternationalizationApplication.class, args);
	}
	@PostConstruct
	public void afterInit() {
		System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080/posts/ \n");
	}
}
