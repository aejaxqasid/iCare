package com.shaikh.exception;

import org.springframework.stereotype.Component;

@Component
public class AppointmentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -6235957838476107464L;

	public AppointmentNotFoundException() {
		super();
	}
	
	public AppointmentNotFoundException(String message) {
		super(message);
	}

}
