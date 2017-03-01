package edu.spring.security.custom.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthorController {
	

	@Secured( value = { "ROLE_ADMIN" })
	@RequestMapping("/authors")
	public String list() {
		
		return "list authors ...";
		
	}

}
