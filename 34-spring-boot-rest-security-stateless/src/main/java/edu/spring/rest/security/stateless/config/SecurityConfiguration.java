package edu.spring.rest.security.stateless.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.spring.rest.security.stateless.auth.StatelessAuthenticationFilter;
import edu.spring.rest.security.stateless.auth.StatelessLoginFilter;
import edu.spring.rest.security.stateless.auth.TokenAuthenticationService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	//private static String REALM="ZHAW";

	private UserDetailsService userService;
	private TokenAuthenticationService tokenAuthenticationService;

	@Autowired
	public SecurityConfiguration(UserDetailsService userService) {
		super(true);
		this.userService = userService;
		tokenAuthenticationService = new TokenAuthenticationService("secretkey", userService);
	}

	@Bean
	public TokenAuthenticationService tokenAuthenticationService() {
		return tokenAuthenticationService;
	}


	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		//auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		//.exceptionHandling().and()
		//.anonymous().and()
		//.servletApi().and()
		//.headers().cacheControl().and()
		.authorizeRequests()
		.antMatchers("/api/login").permitAll()
		.antMatchers("/api/authors/**").hasRole("ADMIN")
		.antMatchers("/api/posts/**").hasRole("USER")
		.anyRequest().authenticated();

		http.addFilterBefore(
				new StatelessLoginFilter(
						"/api/login",
						tokenAuthenticationService,
						userService,
						authenticationManager()),
				UsernamePasswordAuthenticationFilter.class);

		http.addFilterBefore(
				new StatelessAuthenticationFilter(tokenAuthenticationService),
				UsernamePasswordAuthenticationFilter.class);
	}


	/* To allow Pre-flight [OPTIONS] request from browser */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers(HttpMethod.OPTIONS, "/**")
		.antMatchers("/h2-console/**");
	}


}

