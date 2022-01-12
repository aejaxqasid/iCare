package com.shaikh.exception;

import org.springframework.stereotype.Component;

@Component
public class SlotRequestNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3894243476842498670L;

	public SlotRequestNotFoundException() {
		super();
	}
	
	public SlotRequestNotFoundException(String message) {
		super(message);
	}

}
