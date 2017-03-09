package edu.spring.rest.security.stateless.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import edu.spring.rest.security.stateless.domain.User;



public interface UserService extends UserDetailsService{

	public User findByEmail(String email);
	
}
