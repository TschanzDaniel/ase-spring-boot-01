package edu.spring.security.userdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.spring.security.userdetails.domain.User;
import edu.spring.security.userdetails.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByFullName(name);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByEmail(username);
		if( user == null ){
			user = findByName(username);
			if( user == null ) {
				throw new UsernameNotFoundException(username);
			}
		}
		return new UserDetailsImpl(user);
	}
}
