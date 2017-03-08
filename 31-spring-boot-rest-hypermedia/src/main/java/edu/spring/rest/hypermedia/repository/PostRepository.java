package edu.spring.rest.hypermedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.spring.rest.hypermedia.domain.Post;

@RepositoryRestResource(path="blogposts")
public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByAuthorFirstName(@Param("firstName") String firstName);
	List<Post> findByTitleContaining(@Param("title") String title);
}
