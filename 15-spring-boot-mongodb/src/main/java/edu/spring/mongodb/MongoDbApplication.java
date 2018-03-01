package edu.spring.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * curl -X POST -H "Content-Type: application/json" -d '{"firstname": "Matthias", "lastname":"Bachmann"}' http://localhost:8080/customers
 * curl -X GET http://localhost:8080/customers 
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}
}
