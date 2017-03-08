package edu.spring.rest.hypermedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.spring.rest.hypermedia.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
