package com.wearewaes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The sent string is not Base64 encoded.")
public class NoBase64EncodedException extends Exception {

	private static final long serialVersionUID = -1523451759664692443L;
	
	public NoBase64EncodedException(String message) {
		super(message);
	}

}
