package com.tjtyres.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UserAlreadyException extends Exception {

	public UserAlreadyException(String message) {
		super(message);
	}
	
	

}
