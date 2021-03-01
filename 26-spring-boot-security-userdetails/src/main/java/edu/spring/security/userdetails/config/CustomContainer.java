package edu.spring.security.userdetails.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomContainer implements
		WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setPort(8080);
		factory.setContextPath("");
		ErrorPage custom404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/404");
		factory.addErrorPages(custom404Page);
	}
}
