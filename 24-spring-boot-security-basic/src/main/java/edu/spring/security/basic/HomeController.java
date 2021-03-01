package edu.spring.security.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Samples for @RequestMapping, @Pathvariable and @RequestParam
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "")
	@ResponseBody
	public String method0() {
		return "method0";
	}

}
