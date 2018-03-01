package edu.spring.jpa.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.spring.jpa.model.Customer;
import io.swagger.annotations.Api;

/**
 * Repository class for Customer
 */
//@RepositoryRestResource(exported = false)
@Api
@RepositoryRestResource(path = "customers")
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
