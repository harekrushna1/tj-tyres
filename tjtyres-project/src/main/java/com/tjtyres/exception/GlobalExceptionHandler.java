package com.tjtyres.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(FleetNotFoundException.class)
	public ResponseEntity<?> fleetNotFoundException(FleetNotFoundException ex, WebRequest request){
		ErrorDetails errorDetail = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidUserdetails.class)
	public ResponseEntity<?> invalidUserException(InvalidUserdetails ex, WebRequest request){
		ErrorDetails errorDetail = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetail, HttpStatus.UNAUTHORIZED);
	}

}
