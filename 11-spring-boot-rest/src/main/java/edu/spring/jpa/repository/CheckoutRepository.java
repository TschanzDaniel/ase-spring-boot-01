package edu.spring.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.jpa.model.Checkout;

/**
 * Repository class for Checkout
 */
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
