package edu.spring.liquibase.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.spring.liquibase.bootstrap.DatabaseBootstrap;

/**
 * Defines a Bean for the DatabaseBootstrap
 */
@Configuration
public class DevConfiguration {

    @Bean
    public DatabaseBootstrap databaseBootstrap() {
        return new DatabaseBootstrap();
    }

}
