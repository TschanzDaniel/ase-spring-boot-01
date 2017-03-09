package edu.spring.rest.security.stateless.auth;

import com.fasterxml.jackson.annotation.JsonProperty;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Size;
import java.util.Optional;


public final class LoginParams {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(LoginParams.class);

    private final String email;
    @Size(min = 8, max = 100)
    private final String password;

    public LoginParams(@JsonProperty("email") String email,
                      @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
     }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<String> getEncodedPassword() {
        return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
    }
 
    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
    
}
