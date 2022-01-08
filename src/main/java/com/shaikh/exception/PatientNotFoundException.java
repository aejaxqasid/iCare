package com.shaikh.exception;

import org.springframework.stereotype.Component;

@Component
public class PatientNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5287374696821607281L;
	
	public PatientNotFoundException() {
		super();
	}
	
	public PatientNotFoundException(String message) {
		super(message);
	}

}
