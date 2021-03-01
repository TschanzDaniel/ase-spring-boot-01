package edu.spring.security.userdetails.controller;

import java.security.Principal;

import edu.spring.security.userdetails.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/posts")
public class PostController {

	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	private final PostService postService;

	@Autowired
	public PostController(PostService postService){
		this.postService = postService;
	}

	@Secured( value = { "ROLE_USER" ,"ROLE_ADMIN"})
	@RequestMapping(value={"/","/list"})
	public String listPosts(Model model){
		model.addAttribute("posts", postService.list());
		return "post/list";
	}

	@Secured( value = { "ROLE_USER" ,"ROLE_ADMIN"})
	@RequestMapping("/view/{slug}")
	public String view(@PathVariable(value="slug") String slug, Model model){
		logger.info("slug" + slug.toString());
		model.addAttribute("post", postService.getBySlug(slug));
		return "post/view";
	}
	@Secured( value = { "ROLE_USER" ,"ROLE_ADMIN"})
	@RequestMapping("/byAuthor/{id}")
	public String byAuthor(@PathVariable(value="id") Long id, Model model){
		model.addAttribute("posts", postService.listByAuthor(id));
		return "post/list";
	}

	@Secured( value = { "ROLE_ADMIN" })
	@RequestMapping("/admin/create")
	@ResponseBody
	public String createPost(){

		UserDetails userDetails = (UserDetails)SecurityContextHolder
						.getContext()
						.getAuthentication()
						.getPrincipal();

		return "<html>\n" + "<header><title>Welcome</title></header>\n" +
				"<body>\n" +  userDetails.getUsername()
				+ ", auth: " + userDetails.getAuthorities().toString()
				+ " wants create posts...\n" + "</body>\n" + "</html>";

	}

	@Secured( value = { "ROLE_ADMIN" })
	@RequestMapping("/add")
	@ResponseBody
	public String addPost(Principal principal){
		String userName = principal.getName();
		return "<html>\n" + "<header><title>Welcome</title></header>\n" +
				"<body>\n" + userName + " wants to add posts...\n" + "</body>\n" + "</html>";

	}

}
