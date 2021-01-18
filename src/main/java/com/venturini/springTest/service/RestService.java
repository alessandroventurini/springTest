package com.venturini.springTest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService<T> {
	
	private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

	@Transactional
	public ResponseEntity<T> getJson(String url,Class<T> c){
		String finalUrl = BASE_URL.concat(url);
		ResponseEntity<T> response = new RestTemplate().getForEntity(finalUrl,c,HttpStatus.OK);
		return response;	
	}

}
