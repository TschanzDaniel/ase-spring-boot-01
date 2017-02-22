package edu.spring.mvc.thymeleaf.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import edu.spring.mvc.thymeleaf.model.Customer;
import edu.spring.mvc.thymeleaf.repository.CustomerRepository;

/**
 * Created by trainer on 10.03.2016.
 */
public class DatabaseBootstrap implements InitializingBean {

    @Autowired
    CustomerRepository repository;

    private static Logger log = LoggerFactory.getLogger(DatabaseBootstrap.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        if (repository.findByFirstnameAndLastname("Christopher", "Janietz") == null) {
            Customer customer = new Customer();
            customer.setFirstname("Christopher");
            customer.setLastname("Janietz");
            repository.save(customer);
            log.info("Christopher Janietz created");
        }
        log.info("Bootstrap finished");

    }


}
