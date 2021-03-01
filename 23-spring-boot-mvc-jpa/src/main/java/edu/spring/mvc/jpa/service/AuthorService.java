package edu.spring.mvc.jpa.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.mvc.jpa.domain.Author;
import edu.spring.mvc.jpa.repository.AuthorRepository;

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
