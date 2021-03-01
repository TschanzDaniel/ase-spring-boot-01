package edu.spring.security.custom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.inMemoryAuthentication()
				.withUser("admin")
				.password("admin")
				.roles("ADMIN", "SUPER_USER")
			.and()
				.withUser("zhaw")
				.password("hallovelo")
				.roles("USER");
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
				.failureUrl("/login?error")
				.successForwardUrl("/home")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
			.csrf();
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(
				HttpMethod.OPTIONS, "/**",
				"*.js");

	}

}
