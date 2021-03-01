package edu.spring.mvc.jpa;

import edu.spring.mvc.jpa.config.HasLogger;
import edu.spring.mvc.jpa.domain.Author;
import edu.spring.mvc.jpa.domain.Post;
import edu.spring.mvc.jpa.repository.AuthorRepository;
import edu.spring.mvc.jpa.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class BlogApplication implements HasLogger {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
        return args -> {

            Author dv = authorRepository.findByEmailIgnoreCase("Felix.Muster@gmail.com");
            if(dv == null) {
                dv = new Author("Felix","Muster","Felix.Muster@gmail.com");
                authorRepository.save(dv);
                getLogger().debug("Command Runner is active: inserting author: Felix.Muster@gmail.com");
            }

            Post post = new Post("Spring Boot Rocks!");
            post.setSlug("spring-boot-rocks");
            post.setTeaser("Post Teaser");
            post.setBody("Post Body");
            post.setPostedOn(new Date());
            post.setAuthor(dv);
            postRepository.save(post);
            getLogger().debug("Command Runner is active: inserting first post: Spring Boot Rocks!");

            Post rest = new Post("REST is cool");
            rest.setSlug("rest-is-cool");
            rest.setTeaser("REST Teaser");
            rest.setBody("REST BODY");
            rest.setPostedOn(new Date());
            rest.setAuthor(dv);
            postRepository.save(rest);
            getLogger().debug("Command Runner is active: inserting second post: REST is cool");
        };
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("\n\nEnter in Browser:\nhttp://localhost:8080 \n" +
                "http://localhost:8080/h2-console  " + "" +
                "-> mit Generic H2 (Embedded), org.h2.Driver, jdbc:h2:mem:testdb / jdbc:h2:file:./database und sa \n\n");
    }

}
