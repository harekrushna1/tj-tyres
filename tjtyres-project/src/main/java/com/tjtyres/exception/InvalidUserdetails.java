package com.tjtyres.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidUserdetails extends RuntimeException {

	public InvalidUserdetails(String message) {
		super(message);
	}
	

}
