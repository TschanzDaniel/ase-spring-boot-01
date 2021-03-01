package edu.spring.security.userdetails.service;



import edu.spring.security.userdetails.domain.Author;
import edu.spring.security.userdetails.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;

	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	public List<Author> list() {
		return authorRepository.findAllByOrderByLastNameAscFirstNameAsc();
	}

	public Author findOne(Long id) {
		return authorRepository.findById(id).get();
	}


}
