package com.venturini.springTest.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.venturini.springTest.model.Comment;
import com.venturini.springTest.model.Post;
import com.venturini.springTest.model.TestUser;
import com.venturini.springTest.service.RestService;

@RestController
@EnableAutoConfiguration
public class InterfaceController {
	
	private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

	@RequestMapping("/comments")
	public ResponseEntity<Comment[]> getComments() {
		String service = "/posts/1/comments";
		ResponseEntity<Comment[]> result = new RestService<Comment[]>().getJson(service,Comment[].class); 
		return result;
	}
	
	@RequestMapping("/getComments/{userId}")
	public Comment[] getCommentsTwo(@PathVariable("userId") String id) {
		String url = BASE_URL + "/posts/" + id + "/comments";
		Comment[] comment = new RestTemplate().getForObject(url,Comment[].class);
		return comment;
	}
	
	@RequestMapping("/getPosts/{userId}")
	public Post getPostsTwo(@PathVariable("userId") String id) {
		String url = BASE_URL + "/posts/" + id;
		Post post = new RestTemplate().getForObject(url,Post.class);
		return post;
	}
	
	@RequestMapping("/getUser")
	public TestUser getUser() {
		User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		TestUser user = new TestUser();
		user.setUsername(userAuth.getUsername());
		user.setId();
		return user;
	}

}
