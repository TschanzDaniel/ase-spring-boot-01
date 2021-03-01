package edu.spring.rest.hateoas;



import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.spring.rest.hateoas.model.Account;
import edu.spring.rest.hateoas.model.Bookmark;
import edu.spring.rest.hateoas.repository.AccountRepository;
import edu.spring.rest.hateoas.repository.BookmarkRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(HateoasApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
        return (args) ->
            Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(a -> {
                    Account account = accountRepository.save(new Account(a, "password"));
                    bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
                    bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
                });
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
