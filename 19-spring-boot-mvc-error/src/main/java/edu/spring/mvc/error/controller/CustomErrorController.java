package edu.spring.mvc.error.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

@Controller
public class CustomErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";
	private static final String ERROR_TEMPLATE = "customError";

	private final ErrorAttributes errorAttributes;

	@Autowired
	public CustomErrorController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping(ERROR_PATH)
	public String error(Model model,HttpServletRequest request) {

		// {error={timestamp=Mon Nov 02 12:40:50 EST 2015, status=404, error=Not Found, message=No message available, path=/foo}}
		Map<String,Object> error = getErrorAttributes(request, true);

		model.addAttribute("timestamp", error.get("timestamp"));
		model.addAttribute("status", error.get("status"));
		model.addAttribute("error", error.get("error"));
		model.addAttribute("message", error.get("message"));
		model.addAttribute("path", error.get("path"));

		return ERROR_TEMPLATE;
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	@RequestMapping("/404")
	public String pageNotFound(Model model,HttpServletRequest request){
		model.addAttribute("error", getErrorAttributes(request,true));
		return "404";
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		ServletWebRequest servletWebRequest = new ServletWebRequest(request);
		return this.errorAttributes.getErrorAttributes(servletWebRequest, ErrorAttributeOptions.defaults());
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributeOptions options) {
		ServletWebRequest servletWebRequest = new ServletWebRequest(request);
		return this.errorAttributes.getErrorAttributes(servletWebRequest, options);
	}

}
