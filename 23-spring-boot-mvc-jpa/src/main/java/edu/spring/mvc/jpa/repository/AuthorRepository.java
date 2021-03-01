package edu.spring.mvc.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.spring.mvc.jpa.domain.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	List<Author> findAllByOrderByLastNameAscFirstNameAsc();
	Author findByEmailIgnoreCase(String email);
}
