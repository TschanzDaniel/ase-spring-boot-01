package edu.spring.security.userdetails.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import edu.spring.security.userdetails.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	List<Author> findAllByOrderByLastNameAscFirstNameAsc();
}
