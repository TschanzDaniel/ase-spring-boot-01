package edu.spring.mvc.jpa.config;


import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import com.github.dandelion.datatables.core.web.filter.DatatablesFilter;
import com.github.dandelion.datatables.thymeleaf.dialect.DataTablesDialect;
import com.github.dandelion.thymeleaf.dialect.DandelionDialect;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.Environment;

/**
 * Web MVC Configuration
 */
@Configuration
public class WebConfiguration {
	
	@Autowired 
	private Environment environment; 

	@Bean
	public DandelionDialect dandelionDialect()
	{
		return new DandelionDialect();
	}

	@Bean
	public DataTablesDialect dataTablesDialect()
	{
		return new DataTablesDialect();
	}

	@PostConstruct 
	public void init() { 
		if (environment.acceptsProfiles("production")) { 
			System.setProperty("dandelion.profile.active", "prod"); 
		} 
	} 


	@Bean
	public FilterRegistrationBean filterRegistrationBean()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new DandelionFilter());
		return filterRegistrationBean;
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean()
	{
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new DandelionServlet());
		servletRegistrationBean.addUrlMappings("/dandelion-assets/*");
		servletRegistrationBean.setName("dandelionServlet");
		return servletRegistrationBean;
	}

	@Bean 
	@Description("Dandelion-Datatables filter, used for basic export") 
	public FilterRegistrationBean datatablesRegistrationBean() { 
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(); 
		filterRegistrationBean.setFilter(new DatatablesFilter()); 
		return filterRegistrationBean; 
	} 

}