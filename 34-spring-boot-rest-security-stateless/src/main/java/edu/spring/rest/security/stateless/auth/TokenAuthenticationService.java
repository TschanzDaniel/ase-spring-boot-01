package edu.spring.rest.security.stateless.auth;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public class TokenAuthenticationService {

    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

    private TokenHandler tokenHandler = null;


    public TokenAuthenticationService(String secret, UserDetailsService userDetailsService) {
        tokenHandler = new TokenHandler(secret, userDetailsService);
    }

    public String addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
        final UserDetails userDetails = authentication.getDetails();
        String token = tokenHandler.createTokenForUser(userDetails);
        response.addHeader(AUTH_HEADER_NAME, token);
        return token;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            final UserDetails userDetails = tokenHandler.parseUserFromToken(token);
            if (userDetails != null) {
                return new UserAuthentication(userDetails);
            }
        }
        return null;
    }
}
