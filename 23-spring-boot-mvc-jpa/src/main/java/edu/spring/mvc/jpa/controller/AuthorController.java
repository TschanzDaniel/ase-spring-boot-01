package edu.spring.mvc.jpa.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.mvc.jpa.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}

	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("authors", authorService.list());
		return "author/list";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model){
		model.addAttribute("author", authorService.findOne(id));
		return "author/view";
	}

}
