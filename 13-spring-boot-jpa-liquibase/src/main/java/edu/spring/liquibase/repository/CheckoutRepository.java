package edu.spring.liquibase.repository;


import org.springframework.data.repository.CrudRepository;

import edu.spring.liquibase.model.Checkout;

/**
 * Repository class Checkout
 */
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
