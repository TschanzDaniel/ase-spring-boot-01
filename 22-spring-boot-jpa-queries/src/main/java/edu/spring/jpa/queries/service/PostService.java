package edu.spring.jpa.queries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.jpa.queries.domain.Post;
import edu.spring.jpa.queries.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository){
		this.postRepository = postRepository;
	}

	public Iterable<Post> list(){
		return postRepository.findAll();
	}

	// CUSTOM QUERIES

	public List<Post> byAuthor(String first){
		return postRepository.findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(first);
	}

	public List<Post> byKeyword(String keyword) {
		return postRepository.findAllByKeywordsLikeIgnoreCase('%' + keyword + '%');
	}

	public List<Post> findActive() {
		return postRepository.findAllByActiveTrue();
	}

	public Post findBySlug(String slug) {
		return postRepository.findPostBySlugNative(slug);
	}


}
