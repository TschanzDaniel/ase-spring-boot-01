package edu.spring.security.userdetails.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Qualifier("userServiceImpl")
	@Autowired
	private UserDetailsService userService;

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/error", "/favicon.ico", "/404")
        		.antMatchers("/h2-console/**")
				.antMatchers("/404.html")
				.antMatchers("/customError.html")
				.antMatchers("/globalControllerHandler.html");
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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
	        		.antMatchers("/", "/home/**", "/guest/**").permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.usernameParameter("email")
					.failureUrl("/login?error")
					.successForwardUrl("/")
					.permitAll()
					.and()
				.logout()
					.logoutSuccessUrl("/login?logout")
					.permitAll()
					.and()
				.csrf().and().exceptionHandling()
					.accessDeniedPage("/access-denied");;

	}


}
