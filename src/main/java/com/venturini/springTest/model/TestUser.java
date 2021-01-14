package com.venturini.springTest.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class TestUser{

	private String id;
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}
	
	public void setId() {
		if(this.getUsername().equals("user")) {
			this.id = "1";
		}
		else {
			this.id = "2";
		}
	}
	
	

}
