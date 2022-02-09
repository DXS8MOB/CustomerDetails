package com.example.Order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.Order.entity.MessageResponse;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MessageResponse> handleNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		MessageResponse error = new MessageResponse(ex.getMessage());
		return new ResponseEntity<MessageResponse>(error, HttpStatus.NOT_FOUND);
	}
}
