package edu.spring.mongodb.repository;

import edu.spring.mongodb.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for MongoDB with id as String
 */
public interface CustomerRepository extends CrudRepository<Customer, String> {
}
