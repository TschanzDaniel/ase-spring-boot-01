package edu.spring.mvc.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.spring.mvc.jpa.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

	/*
	 * return the last post that was created.
	 */
	Post findFirstByOrderByPostedOnDesc();

	List<Post> findAllByOrderByPostedOnDesc();

	Post findBySlug(String slug);
	
	List<Post> findAllByAuthorIdOrderByPostedOnDesc(Long id);


}
