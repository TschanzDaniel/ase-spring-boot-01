package edu.spring.rest.security.stateless.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.rest.security.stateless.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
