package edu.spring.rest.hateoas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Account {

    @OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public String password;
    public String username;

    public Account(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public Account() { // jpa only
    }
}
