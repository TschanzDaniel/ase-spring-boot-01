package edu.spring.rest.hateoas.repository;



import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.spring.rest.hateoas.model.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByAccountUsername(String username);
    Bookmark findBookmarksById(Long id);
}
