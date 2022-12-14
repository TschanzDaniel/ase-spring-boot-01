package edu.spring.rest.security.basic.domain;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;


@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	@Column(columnDefinition = "TEXT")
	private String body;

	@Column(columnDefinition = "TEXT")
	private String teaser;

	private String slug;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date postedOn;

	@ManyToOne
	//@JsonManagedReference
	private Author author;

	public Post(){
	}

	public Post(Long id, String title, String body, String teaser, String slug, Date postedOn, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.teaser = teaser;
		this.slug = slug;
		this.postedOn = postedOn;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post(String title){
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + "]";
	}

}
