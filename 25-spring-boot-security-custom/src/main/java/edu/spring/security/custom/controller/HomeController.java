package edu.spring.security.custom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value={"/"})
	public String home(){
		return "home/home";
	}

	@RequestMapping(value={"/home"})
	public String home_home(){
		return "home/home";
	}


}
