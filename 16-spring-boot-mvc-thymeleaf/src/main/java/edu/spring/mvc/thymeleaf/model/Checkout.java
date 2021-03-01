package edu.spring.mvc.thymeleaf.model;

import javax.persistence.*;

/**
 * Checkout Entity with JPA
 */
@Entity
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
