package edu.spring.rest.security.stateless.service;

import edu.spring.rest.security.stateless.domain.Post;

public interface PostService {
	
	Iterable<Post> list();
	
	Post create(Post post);
	
	Post read(long id);
	
	Post update(long id, Post post);
	
	void delete(long id);
}
