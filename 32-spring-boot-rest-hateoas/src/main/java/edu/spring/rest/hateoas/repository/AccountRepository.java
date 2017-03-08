package edu.spring.rest.hateoas.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.spring.rest.hateoas.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
