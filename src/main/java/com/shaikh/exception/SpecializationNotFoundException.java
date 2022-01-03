package com.shaikh.exception;

import org.springframework.stereotype.Component;

@Component
public class SpecializationNotFoundException extends RuntimeException {

	public SpecializationNotFoundException() {
		super();
	}
	
	public SpecializationNotFoundException(String message) {
		super(message);
	}
}
