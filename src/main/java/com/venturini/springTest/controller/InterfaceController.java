package com.venturini.springTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterfaceController {
	
	@RequestMapping("/bean")
	public String hello() {
		return "Hello World";
	}

}
