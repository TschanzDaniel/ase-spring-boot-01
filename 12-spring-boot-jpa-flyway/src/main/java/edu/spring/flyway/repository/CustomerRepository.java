package edu.spring.flyway.repository;


import org.springframework.data.repository.CrudRepository;

import edu.spring.flyway.model.Customer;



/**
 * Repository class Customer
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Customer findByFirstnameAndLastname(String firstname, String lastname);

}
