package edu.spring.jpa.repository;


import org.springframework.data.repository.CrudRepository;

import edu.spring.jpa.model.Customer;

/**
 * Repository class for Customer
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
