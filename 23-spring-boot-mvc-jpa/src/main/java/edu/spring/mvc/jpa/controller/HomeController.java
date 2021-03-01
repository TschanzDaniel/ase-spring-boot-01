package edu.spring.mvc.jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.mvc.jpa.service.PostService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private final PostService postService;

	@Autowired
	public HomeController(PostService postService){
		this.postService = postService;
	}

	@RequestMapping("/")
	public String home(Model model){
		model.addAttribute("post", postService.getLatestPost());
		logger.info(postService.getLatestPost().toString());
		return "index";
	}

}
