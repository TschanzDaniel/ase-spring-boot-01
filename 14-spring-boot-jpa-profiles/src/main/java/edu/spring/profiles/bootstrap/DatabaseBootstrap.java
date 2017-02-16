package edu.spring.profiles.bootstrap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import edu.spring.profiles.config.DataSourceProperties;
import edu.spring.profiles.model.Customer;
import edu.spring.profiles.repository.CustomerRepository;

/**
 * manually fill-in data to DataBase 
 */
public class DatabaseBootstrap implements InitializingBean {

    @Autowired
    CustomerRepository repository;

    @Autowired
    DataSourceProperties dataSourceProperties;
    
    private static Logger log = LoggerFactory.getLogger(DatabaseBootstrap.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        if (repository.findByFirstnameAndLastname("Felix", "Muster") == null) {
            Customer customer = new Customer();
            customer.setFirstname("Felix");
            customer.setLastname("Muster");
            repository.save(customer);
            log.info(customer.getFirstname() + " " + customer.getLastname() + " created");
        }
        log.info("Bootstrap finished");
        log.info("dataSourceProperties: " + dataSourceProperties.getDriverClassName());
        log.info("myOtherUrl: " + dataSourceProperties.getMyOtherUrl());

    }


}
