package com.wearewaes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Person Left or Right not found!")
public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = -7758968109515877922L;

	public PersonNotFoundException(String message) {
		super(message);
	}

}
