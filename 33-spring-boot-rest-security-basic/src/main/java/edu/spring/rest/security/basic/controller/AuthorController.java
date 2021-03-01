package edu.spring.rest.security.basic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.rest.security.basic.domain.Author;
import edu.spring.rest.security.basic.repository.AuthorRepository;

@RestController

@Tag(name = "authors", description = "The Authors API - you need admin rights")
@RequestMapping("/api/authors")
public class AuthorController {

	AuthorRepository authorRepository;

	@Autowired
	public AuthorController(AuthorRepository authorRepository){
		this.authorRepository = authorRepository;
	}

	@Operation(summary = "List all Authors", security = @SecurityRequirement(name = "basicAuth"))
	@RequestMapping("/")
	public Iterable<Author> list(){
		return authorRepository.findAll();
	}

	@Operation(summary = "Get one Author by id", security = @SecurityRequirement(name = "basicAuth"))
	@RequestMapping("/{id}")
	public Author read(@PathVariable(value="id") long id){
		return authorRepository.findById(id).get();
	}

}
