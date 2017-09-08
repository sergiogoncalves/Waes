package com.wearewaes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The encoded string is not a PersonDTO class.")
public class NotPersonDTOException extends Exception {

	private static final long serialVersionUID = 8270438830668458334L;
	
	public NotPersonDTOException(String message) {
		super(message);
	}


}
