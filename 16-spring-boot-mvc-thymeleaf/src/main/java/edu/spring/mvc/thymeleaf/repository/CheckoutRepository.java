package edu.spring.mvc.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.mvc.thymeleaf.model.Checkout;

/**
 * Checkout Repository for JPA
 */
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
