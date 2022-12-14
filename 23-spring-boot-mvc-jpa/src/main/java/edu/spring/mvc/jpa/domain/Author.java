package edu.spring.mvc.jpa.domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public Author(){

	}

	public Author(String first, String last,String email){
		this.setFirstName(first);
		this.setLastName(last);
		this.setEmail(email);
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
