package edu.spring.security.userdetails.controller;

import edu.spring.security.userdetails.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/authors")
@Controller
public class AuthorController {

	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	@Secured( value = { "ROLE_ADMIN" })
	@RequestMapping(value={"/","/list"})

	public String list(Model model){
		model.addAttribute("authors", authorService.list());
		return "author/list";
	}

	@Secured( value = { "ROLE_ADMIN" })
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model){
		model.addAttribute("author", authorService.findOne(id));
		return "author/view";
	}

}
