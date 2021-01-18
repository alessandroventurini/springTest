package com.venturini.springTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

import com.venturini.springTest.exception.RestTemplateException;

@ControllerAdvice
public class ExceptionController {

	
	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<RestTemplateException> handleRestClientException(RestClientException err){
		RestTemplateException rte = new RestTemplateException(HttpStatus.INTERNAL_SERVER_ERROR,err.getMessage());
		return new ResponseEntity<RestTemplateException>(rte,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
