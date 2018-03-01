package edu.spring.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.jpa.model.Checkout;
import io.swagger.annotations.Api;

/**
 * Repository class for Checkout
 */
@Api
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
