package edu.spring.mvc.error.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.mvc.error.controller.exception.PostNotFoundException;
import edu.spring.mvc.error.domain.Post;


@Controller
@RequestMapping("/posts")
public class PostController {
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@RequestMapping("/get/{slug}")
	public String getPost( @PathVariable(value="slug") String slug ) throws Exception {
		Post post = null;
		if (slug.equals("ok")) post = new Post();
			
		logger.info("getPost called with slug: " + slug);
		
		if (slug.equals("notok")) throw new Exception("slug is: " + slug);
		if( post == null ) throw new PostNotFoundException("We couldn't find the post with slug: " + slug);
		return "index";
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public String handleException(HttpServletRequest req, Exception exception, Model model){
		logger.info("PostNotFoundException errorMessage: " + exception.getMessage());
		model.addAttribute("errorMessage", exception.getMessage() );
		return "post/error";
	}
	
	
}
