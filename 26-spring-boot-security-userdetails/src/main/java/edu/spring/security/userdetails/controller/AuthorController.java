package edu.spring.security.userdetails.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthorController {
	

	@Secured( value = { "ROLE_ADMIN" })
	@RequestMapping(value={"/authors","/authors/list"})
	public String list() {
		
		return "list authors ...";
		
	}

}
