package edu.spring.rest.security.basic.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.rest.security.basic.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
