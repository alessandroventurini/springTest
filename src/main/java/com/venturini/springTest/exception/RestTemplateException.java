package com.venturini.springTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;

public class RestTemplateException extends Exception {
	
	private HttpStatus statusCode;
	private String error;
	
	public RestTemplateException(HttpStatus statusCode, String error) {
		super(error);
		this.statusCode = statusCode;
		this.error = error;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "RestTemplateException [statusCode=" + statusCode + ", error=" + error + "]";
	}
	
	
	
	

}
