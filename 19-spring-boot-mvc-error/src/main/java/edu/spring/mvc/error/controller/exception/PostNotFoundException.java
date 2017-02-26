package edu.spring.mvc.error.controller.exception;

public class PostNotFoundException extends Exception {

	private static final long serialVersionUID = -8735655508504391114L;
	
	public PostNotFoundException(String string) {
		super(string);
	}

}
