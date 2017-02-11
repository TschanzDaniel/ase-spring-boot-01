package edu.spring.profiles.repository;


import org.springframework.data.repository.CrudRepository;

import edu.spring.profiles.model.Customer;



/**
 * Repository class Customer
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Customer findByFirstnameAndLastname(String firstname, String lastname);

}
