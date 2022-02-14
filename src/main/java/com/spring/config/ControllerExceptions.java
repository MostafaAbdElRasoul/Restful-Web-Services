package com.spring.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.exception.StudentException;
import com.spring.model.StudentError;

@ControllerAdvice
public class ControllerExceptions {
	@ExceptionHandler
	public ResponseEntity<StudentError> getExceptionNotFound(StudentException se) {
		StudentError studentError = new StudentError();
		studentError.setStatusCode(HttpStatus.NOT_FOUND.value());
		studentError.setMessage(se.getMessage());
		studentError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentError>(studentError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentError> getException(Exception e) {
		StudentError studentError = new StudentError();
		studentError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		studentError.setMessage(e.getMessage());
		studentError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentError>(studentError, HttpStatus.BAD_REQUEST);
	}
}
