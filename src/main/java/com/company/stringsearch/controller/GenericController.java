package com.company.stringsearch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.company.stringsearch.model.ErrorResponse;

import lombok.extern.log4j.Log4j2;

/**
 * The Class PostCodeController.
 */
@RestController

/** The Constant log. */
@Log4j2
public class GenericController {

	

	/**
	 * Handle exception.
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		// Code to send different error codes and description based on business
		// exception types
		log.error(e);

		// Send an email to the administrator
		// Return error details to the client
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode("ERROR");
		response.setErrorDescription("Unhandled Server Error");
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
