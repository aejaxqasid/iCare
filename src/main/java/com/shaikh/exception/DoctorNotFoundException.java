package com.shaikh.exception;

import org.springframework.stereotype.Component;

@Component
public class DoctorNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1660770542716208461L;

	public DoctorNotFoundException() {
		super();
	}
	
	public DoctorNotFoundException(String message) {
		super(message);
	}
	
}
