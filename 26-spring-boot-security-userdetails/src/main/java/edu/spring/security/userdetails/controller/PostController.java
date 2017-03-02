package edu.spring.security.userdetails.controller;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@RequestMapping(value={"/posts/","/posts/list"})
	public String list(){
		return "list posts...";
	}
	
	@RequestMapping("/admin/posts/create")
	public String createPost(){
		
		UserDetails userDetails = (UserDetails)SecurityContextHolder
						.getContext()
						.getAuthentication()
						.getPrincipal();
		
		return "user: " + userDetails.getUsername()
				+ ", auth: " + userDetails.getAuthorities().toString()
				+ " wants create posts...";
	}
	
	@Secured( value = { "ROLE_ADMIN" })
	@RequestMapping("/posts/add")
	public String addPost(Principal principal){
		String userName = principal.getName();
		return userName + " wants to add posts...";
	}

}
