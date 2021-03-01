package edu.spring.rest.hateoas.model;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bookmark {

    @JsonIgnore
    @ManyToOne
    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Bookmark() { // jpa only
    }

    public Bookmark(Account account, String uri, String description) {
        this.uri = uri;
        this.description = description;
        this.account = account;
    }

    public String uri;
    public String description;

    public Account getAccount() {
        return account;
    }

    public Long getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public String getDescription() {
        return description;
    }
}
