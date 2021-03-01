package edu.spring.rest.security.basic.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.rest.security.basic.domain.Post;
import edu.spring.rest.security.basic.exception.PostNotFoundException;
import edu.spring.rest.security.basic.service.PostService;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "authors", description = "The Posts API - you need user or admin rights")
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService){
		this.postService = postService;
	}

	@Operation(summary = "List all Posts", security = @SecurityRequirement(name = "basicAuth"))
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public Iterable<Post> list(){
		return postService.list();
	}

	@Operation(summary = "Create a post", security = @SecurityRequirement(name = "basicAuth"))
	@RequestMapping( value = "/", method = RequestMethod.POST )
	public Post create(@RequestBody Post post){
		return postService.create(post);
	}

	@Operation(summary = "Get a post by id", security = @SecurityRequirement(name = "basicAuth"))
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public Post read(@PathVariable(value="id") long id) throws PostNotFoundException {
		Post post = postService.read(id);
		if( post == null ){
			throw new PostNotFoundException("Post with id: " + id + " not found.");
		}
		return post;
	}

	@Operation(summary = "Update a post by id", security = @SecurityRequirement(name = "basicAuth"))
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public Post update(@PathVariable(value="id") long id, @RequestBody Post post){
		return postService.update(id,post);
	}

	@Operation(summary = "Delete a post by id", security = @SecurityRequirement(name = "basicAuth"))
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	public void delete(@PathVariable(value="id") int id){
		postService.delete(id);
	}

	@ExceptionHandler(PostNotFoundException.class)
	public void handlePostNotFound(PostNotFoundException exception, HttpServletResponse response) throws IOException{
		response.sendError( HttpStatus.NOT_FOUND.value(), exception.getMessage() );
	}


}
