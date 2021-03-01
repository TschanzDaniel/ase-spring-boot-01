package edu.spring.jpa.queries.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.spring.jpa.queries.domain.Author;
import edu.spring.jpa.queries.domain.Post;
import edu.spring.jpa.queries.repository.AuthorRepository;
import edu.spring.jpa.queries.repository.PostRepository;

@Component
public class DataLoader {

	private final PostRepository postRepository;
	private final AuthorRepository authorRepository;

	@Autowired
	public DataLoader(PostRepository postRepository,AuthorRepository authorRepository){
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}

	@PostConstruct
	private void loadData(){

		postRepository.deleteAll();
		authorRepository.deleteAll();

		// create an author
		Author dv = new Author("Felix","Muster","felix.muster@example.com");
		authorRepository.save(dv);

		// create some posts
		createPosts( dv );

	}

	private void createPosts(Author author) {

		Date yesterday = null;
		try {
			yesterday = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a").parse("26/02/2021 12:00:00 PM");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Post post = new Post("Spring Data is powerful!");
		post.setSlug("spring-data-is-powerful");
		post.setTeaser( getTeaser() );
		post.setBody( getBody() );
		post.setPostedOn( yesterday );
		post.setKeywords( getSpringKeywords() );
		post.setActive(false);
		post.setAuthor( author );
		postRepository.save(post);

		Post grails = new Post("ZHAW is super!");
		grails.setSlug("zhaw-is-super");
		grails.setTeaser( getTeaser() );
		grails.setBody( getBody() );
		grails.setPostedOn( new Date() );
		grails.setKeywords( getZhawKeywords() );
		grails.setActive(true);
		grails.setAuthor( author );
		postRepository.save(grails);

	}

	private List<String> getSpringKeywords(){
		List<String> keywords = new ArrayList<String>();
		keywords.add("Spring");
		keywords.add("Spring Data");
		return keywords;
	}

	private List<String> getZhawKeywords(){
		List<String> keywords = new ArrayList<String>();
		keywords.add("ZHAW");
		keywords.add("Zürich");
		keywords.add("Winterthur");
		keywords.add("Wädenswil");
		return keywords;
	}

	private String getTeaser(){
		return "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam et euismod tortor. Pellentesque sed neque a magna sagittis placerat. Donec nisi dolor, efficitur nec dictum sit amet, sollicitudin consequat tortor. Integer a tincidunt erat, non tempor nisi. Duis quis ex ut tellus sagittis accumsan. Curabitur vehicula, dui ac aliquam sodales, lacus augue egestas odio, ac porttitor ipsum orci nec lectus. Maecenas maximus libero quam, eu mollis tellus blandit vitae.</p>";
	}

	private String getBody(){
		String body = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt et turpis non lobortis. Nullam pellentesque magna eros, et ultricies elit aliquet ut. Nunc et eros ligula. In purus nunc, iaculis quis aliquet ut, rutrum sed dolor. Proin ante turpis, euismod nec varius id, dapibus vel nisi. In bibendum mi in metus ultricies, fringilla gravida mi cursus. Integer nec sapien libero. Ut arcu ex, volutpat sed ex finibus, sodales efficitur eros. Sed sapien justo, tincidunt nec pharetra non, ultricies ac nunc. Mauris ac semper dui. Sed eleifend sit amet erat accumsan suscipit. Aliquam sit amet ipsum mauris. Maecenas sollicitudin, nibh sagittis vulputate tincidunt, neque neque vehicula augue, et lacinia dui nisi vulputate velit. Maecenas sit amet augue interdum, suscipit velit malesuada, fermentum orci.</p>";
			  body += "<p>In sit amet mi sollicitudin, iaculis erat venenatis, fringilla turpis. Suspendisse potenti. Curabitur sed molestie eros. Phasellus ultrices, nisi a egestas commodo, ante nisl lobortis diam, at molestie quam lorem eget tellus. Maecenas venenatis sapien ut euismod tempus. Nunc gravida vitae ante faucibus iaculis. Donec nulla dolor, placerat sit amet iaculis at, ornare quis turpis. Proin pharetra vel massa at vulputate. Phasellus efficitur pretium auctor. Mauris tincidunt velit metus, ac varius ante porta vel.</p>";
			  body += "<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec quis diam elementum, feugiat elit a, vestibulum neque. Proin in augue fringilla, sollicitudin dolor vel, fringilla libero. Aenean iaculis ante ligula, sit amet maximus ante viverra at. Quisque auctor arcu et ante consectetur vulputate. Suspendisse iaculis libero eu enim eleifend, non mattis leo aliquet. Fusce id nibh euismod, convallis leo ac, rutrum arcu. Nullam at urna commodo diam pharetra vulputate sed vitae mi. Aenean molestie ante nec finibus aliquet. Suspendisse ac turpis vehicula, semper tortor sit amet, sollicitudin ante. Morbi vehicula sem non elit tempor molestie. In convallis, quam ut porta sagittis, tortor nibh euismod dolor, eget sollicitudin massa mauris nec mi. Proin consectetur lacinia commodo. Quisque at consectetur velit. Pellentesque vel sagittis orci, sed scelerisque diam.</p>";
		return body;
	}

}
