package edu.spring.security.userdetails.repository;

import org.springframework.data.repository.CrudRepository;

import edu.spring.security.userdetails.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
