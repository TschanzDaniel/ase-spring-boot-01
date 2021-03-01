package edu.spring.rest.hypermedia;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.spring.rest.hypermedia.domain.Author;
import edu.spring.rest.hypermedia.domain.Post;
import edu.spring.rest.hypermedia.repository.AuthorRepository;
import edu.spring.rest.hypermedia.repository.PostRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HypermediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HypermediaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
    	return args -> {

	    	Author dv = new Author("Felix","Muster","Felix.Muster@gmail.com");
	    	authorRepository.save( dv );

	    	Post post = new Post("Spring Boot Rocks!");
	    	post.setSlug("spring-boot-rocks");
	    	post.setTeaser("Post Teaser");
	    	post.setBody("Post Body");
	    	post.setPostedOn(new Date());
	    	post.setAuthor(dv);
	    	postRepository.save(post);

	    	Post rest = new Post("REST is cool");
	    	rest.setSlug("rest-is-cool");
	    	rest.setTeaser("REST Teaser");
	    	rest.setBody("REST BODY");
	    	rest.setPostedOn(new Date());
	    	rest.setAuthor(dv);
	    	postRepository.save(rest);

    	};
    }
	@PostConstruct
	public void afterInit() {
		System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080 \n" +
				"http://localhost:8080/v3/api-docs\n" +
				"http://localhost:8080/swagger-ui.html \n" +
				"http://localhost:8080/h2-console  " + "" +
				"-> mit Generic H2 (Embedded), org.h2.Driver, jdbc:h2:mem:testdb / jdbc:h2:file:./database und sa \n\n");
	}


}
