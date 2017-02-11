package edu.spring.profiles.repository;


import org.springframework.data.repository.CrudRepository;

import edu.spring.profiles.model.Checkout;

/**
 * Repository class Checkout
 */
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
