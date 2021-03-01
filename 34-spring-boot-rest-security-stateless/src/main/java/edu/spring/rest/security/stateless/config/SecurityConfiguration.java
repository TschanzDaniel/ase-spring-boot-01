package edu.spring.rest.security.stateless.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.spring.rest.security.stateless.auth.StatelessAuthenticationFilter;
import edu.spring.rest.security.stateless.auth.StatelessLoginFilter;
import edu.spring.rest.security.stateless.auth.TokenAuthenticationService;



@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsService userService;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
	public SecurityConfiguration(@Qualifier("userServiceImpl") UserDetailsService userService) {

		super(true);
		this.userService = userService;
		tokenAuthenticationService = new TokenAuthenticationService("secretkey", userService);
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }

    @Bean
	public TokenAuthenticationService tokenAuthenticationService() {
		return tokenAuthenticationService;
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        //h2 database console
        http.headers().frameOptions().disable();

        http.exceptionHandling()
            .and().anonymous()
            .and().servletApi()
            .and().headers().cacheControl();

        http.authorizeRequests()
        	.antMatchers("/api/login").permitAll()
        	.antMatchers("/api/authors/**").hasRole("ADMIN")
        	.antMatchers("/api/posts/**").hasAnyRole("USER", "ADMIN")
        	//.antMatchers("/api/posts/**").permitAll()
            .antMatchers(HttpMethod.GET, "/h2-console/**").permitAll();

        http.addFilterBefore(
                new StatelessLoginFilter("/api/login", tokenAuthenticationService, userService, authenticationManager()),
                UsernamePasswordAuthenticationFilter.class);

        http.addFilterBefore(
                new StatelessAuthenticationFilter(tokenAuthenticationService),
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	// auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
        auth.userDetailsService(userService);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userService;
    }

    /* To allow Pre-flight [OPTIONS] request from browser */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers(HttpMethod.OPTIONS, "/**")
		.antMatchers("/h2-console/**");
	}

}
