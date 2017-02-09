package edu.spring.liquibase.repository;


import org.springframework.data.repository.CrudRepository;

import edu.spring.liquibase.model.Customer;



/**
 * Repository class Customer
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Customer findByFirstnameAndLastname(String firstname, String lastname);

}
