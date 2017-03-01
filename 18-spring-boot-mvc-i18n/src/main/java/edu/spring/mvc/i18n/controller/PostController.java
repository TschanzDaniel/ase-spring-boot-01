package edu.spring.mvc.i18n.controller;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.LocaleResolver;


@Controller
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private LocaleResolver localeResolver;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/")
	public ModelAndView list(HttpServletRequest request){

    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");     
    	Calendar cal = Calendar.getInstance(); 
    	Locale locale=localeResolver.resolveLocale(request);
    	
    	String welcome = messageSource.getMessage(
    		       "welcome.message", 
    		       new Object[]{"Felix Muster"}, 
    		       locale);
     	
    	return new ModelAndView("views/list")
    	    .addObject("locale", locale)	
    	    .addObject("welcome", welcome)
		    .addObject("today", dateFormat.format(cal.getTime()));
	}

}
