package edu.spring.rest.basic.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.rest.basic.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
