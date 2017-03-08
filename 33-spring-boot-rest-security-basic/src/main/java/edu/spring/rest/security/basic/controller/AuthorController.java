package edu.spring.rest.security.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.rest.security.basic.domain.Author;
import edu.spring.rest.security.basic.repository.AuthorRepository;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	AuthorRepository authorRepository;
	
	@Autowired
	public AuthorController(AuthorRepository authorRepository){
		this.authorRepository = authorRepository;
	}

	@RequestMapping("/")
	public Iterable<Author> list(){
		return authorRepository.findAll();
	}
	
	@RequestMapping("/{id}")
	public Author read(@PathVariable(value="id") long id){
		return authorRepository.findOne(id);
	}
	
}
