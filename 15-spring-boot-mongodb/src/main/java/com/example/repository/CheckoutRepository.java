package com.example.repository;

import com.example.model.Checkout;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Checkout and MongoDB with ID as String
 */
public interface CheckoutRepository extends CrudRepository<Checkout, String> {
}
