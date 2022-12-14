package edu.spring.mvc.thymeleaf.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.spring.mvc.thymeleaf.model.Customer;
import edu.spring.mvc.thymeleaf.repository.CustomerRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Customer Controller for Spring MVC
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView getCustomers() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
    	Calendar cal = Calendar.getInstance();

        return new ModelAndView("customers")
        		.addObject("today", dateFormat.format(cal.getTime()))
                .addObject("customers", repository.findAll())
                .addObject("createLink", linkTo(
                        methodOn(CustomerController.class).createCustomer(null, null))
                        .withRel("Create")
                );
    }

    @RequestMapping(value = "/customers/create", method = RequestMethod.POST)
    public ModelAndView createCustomer(String firstname, String lastname) {
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        repository.save(customer);
        return new ModelAndView("created-customer").addObject("overview",
                linkTo(methodOn(CustomerController.class).getCustomers()).withRel("Overview")
        );
    }
}
