package edu.spring.jpa.queries.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.jpa.queries.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
