package edu.spring.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Customer Model for MongoDB
 */
@Document
public class Customer {

	@Id
	private String id;
	private String firstname;
	@Indexed
	private String lastname;

	public Customer() {
		
	}
	@PersistenceConstructor
	public Customer( String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
