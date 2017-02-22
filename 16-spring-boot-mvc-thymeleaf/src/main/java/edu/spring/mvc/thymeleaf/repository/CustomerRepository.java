package edu.spring.mvc.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.mvc.thymeleaf.model.Customer;

/**
 * Customer Repository for JPA
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Customer findByFirstnameAndLastname(String firstname, String lastname);

}
