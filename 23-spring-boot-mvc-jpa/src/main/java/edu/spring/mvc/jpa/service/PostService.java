package edu.spring.mvc.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.mvc.jpa.domain.Post;
import edu.spring.mvc.jpa.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository){
		this.postRepository = postRepository;
	}

	public Post getLatestPost(){
		return postRepository.findFirstByOrderByPostedOnDesc();
	}

	public List<Post> list() {
		return postRepository.findAllByOrderByPostedOnDesc();
	}

	public Post getBySlug(String slug) {
		return postRepository.findBySlug(slug);
	}

	public List<Post> listByAuthor(Long id) {
		return postRepository.findAllByAuthorIdOrderByPostedOnDesc(id);
	}

}
