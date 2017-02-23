package edu.spring.mvc.i18n.controller;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.LocaleResolver;


@Controller
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	LocaleResolver localeResolver;

	@RequestMapping("/")
	public ModelAndView list(HttpServletRequest request){

    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");     
    	Calendar cal = Calendar.getInstance(); 
    	Locale locale=localeResolver.resolveLocale(request);
    	
    	
     	
    	return new ModelAndView("views/list")
    	.addObject("locale", locale)		
		.addObject("today", dateFormat.format(cal.getTime()));

	}

}
