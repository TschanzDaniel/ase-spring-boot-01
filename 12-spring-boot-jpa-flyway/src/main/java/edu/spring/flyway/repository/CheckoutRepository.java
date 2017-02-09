package edu.spring.flyway.repository;


import org.springframework.data.repository.CrudRepository;

import edu.spring.flyway.model.Checkout;

/**
 * Repository class Checkout
 */
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
