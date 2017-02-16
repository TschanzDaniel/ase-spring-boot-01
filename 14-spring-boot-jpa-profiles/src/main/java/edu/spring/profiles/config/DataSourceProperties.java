package edu.spring.profiles.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="spring.datasource")
public class DataSourceProperties {
	
	private String driverClassName;
	
	@Value("${myOther.url:127.0.0.1}")
	private String myOtherUrl;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	public String getMyOtherUrl() {
		return myOtherUrl;
	}


}
