package com.venturini.springTest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.venturini.springTest.exception.hanlder.RestTemplateErrorHandler;

@Service
public class RestService<T> {
	
	private static final String BASE_URL = "http://jsonplaceholder.typicode.com/pippo";

	@Transactional
	public ResponseEntity<T> getJson(String url,Class<T> c){
		String finalUrl = BASE_URL.concat(url);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		ResponseEntity<T> response = restTemplate.getForEntity(finalUrl,c,HttpStatus.OK);
		return response;
	}

}
