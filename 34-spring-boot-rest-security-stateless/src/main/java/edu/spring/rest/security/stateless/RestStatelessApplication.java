package edu.spring.rest.security.stateless;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import edu.spring.rest.security.stateless.config.HasLogger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.spring.rest.security.stateless.domain.Author;
import edu.spring.rest.security.stateless.domain.Post;
import edu.spring.rest.security.stateless.repository.AuthorRepository;
import edu.spring.rest.security.stateless.repository.PostRepository;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RestStatelessApplication  implements HasLogger {

    public static void main(String[] args) {
        SpringApplication.run(RestStatelessApplication.class, args);
    }

	@Autowired
	private Environment env;

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
	private void logApplicationStartup() {
		String protocol = "http";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		String serverPort = env.getProperty("server.port");
		String contextPath = env.getProperty("server.servlet.context-path");
		if (StringUtils.isBlank(contextPath)) {
			contextPath = "/";
		}
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			getLogger().warn("The host name could not be determined, using `localhost` as fallback");
		}

		String h2Console ="";
		String openApi ="";
		if (Arrays.asList(env.getActiveProfiles()).contains("dev")) {
			h2Console = "H2 Console:\t" + protocol + "://localhost:" + serverPort + contextPath + "h2-console\n\t";
			openApi = "Open API:\t" + protocol + "://localhost:" + serverPort + contextPath + "swagger-ui.html\n\t";
		}
		getLogger().info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\t{}://localhost:{}{}\n\t" +
						"External: \t{}://{}:{}{}\n\t" +
						h2Console + openApi + "\n\t" +
						"Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.getActiveProfiles());

	}


}
