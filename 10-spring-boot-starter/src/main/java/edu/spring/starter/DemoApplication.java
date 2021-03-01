package edu.spring.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

// Generated code from spring starter
//@SpringBootApplication
//public class DemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//}


/**
 * Hello World Example
 * curl -X GET http://localhost:8080
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World";
	}

	@PostConstruct
	public void afterInit() {
		System.out.println("\n\nEnter in Browser: http://localhost:8080\n\n");
	}

}
