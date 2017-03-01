package edu.spring.mvc.thymeleaf.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import edu.spring.mvc.thymeleaf.model.Customer;
import edu.spring.mvc.thymeleaf.repository.CustomerRepository;

/**
 * Database Bootstrap
 */
public class DatabaseBootstrap implements InitializingBean {

    @Autowired
    CustomerRepository repository;

    private static Logger log = LoggerFactory.getLogger(DatabaseBootstrap.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        if (repository.findByFirstnameAndLastname("Felix", "Muster") == null) {
            Customer customer = new Customer();
            customer.setFirstname("Felix");
            customer.setLastname("Muster");
            repository.save(customer);
            log.info("Felix Muster created");
        }
        log.info("Bootstrap finished");

    }


}
