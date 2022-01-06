package com.shaikh.exception;

import org.springframework.stereotype.Component;

@Component
public class SpecializationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8720958097292374015L;

	public SpecializationNotFoundException() {
		super();
	}
	
	public SpecializationNotFoundException(String message) {
		super(message);
	}
}
