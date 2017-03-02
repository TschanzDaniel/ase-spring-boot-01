package edu.spring.security.userdetails.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "author" )
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	
	//posts
	@OneToMany( mappedBy = "author" )
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@SuppressWarnings("unused")
	private Author(){
		
	}
	
	public Author(String first, String last){
		this.setFirstName(first);
		this.setLastName(last);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
