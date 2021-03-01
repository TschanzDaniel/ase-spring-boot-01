package edu.spring.rest.security.stateless.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.rest.security.stateless.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByEmailIgnoreCase(String email);


}
