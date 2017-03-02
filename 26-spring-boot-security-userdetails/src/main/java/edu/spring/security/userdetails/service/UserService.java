package edu.spring.security.userdetails.service;

import edu.spring.security.userdetails.domain.User;

public interface UserService {

	public User findByEmail(String email);
	
}
