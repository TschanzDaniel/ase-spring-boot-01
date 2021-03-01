package edu.spring.mvc.error.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.ServletWebRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private final ErrorAttributes errorAttributes;

	@Autowired
	public ExceptionControllerAdvice(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@ExceptionHandler(Exception.class)
	public String exception(HttpServletRequest request, Exception exception, Model model){
		model.addAttribute("exception", exception);

		Map<String,Object> error = getErrorAttributes(request, true);

		model.addAttribute("timestamp", error.get("timestamp"));
		model.addAttribute("status", error.get("status"));
		model.addAttribute("error", exception.getClass().getName());
		model.addAttribute("message", error.get("message"));
		model.addAttribute("path", request.getRequestURL());

		return "globalControllerHandler";
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
