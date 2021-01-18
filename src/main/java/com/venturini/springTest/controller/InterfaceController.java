package com.venturini.springTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
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
	
	Logger logger = LoggerFactory.getLogger(InterfaceController.class);
	
	private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

	@RequestMapping("/comments")
	public ResponseEntity<Comment[]> getComments() {
		String service = "/posts/1/comments";
		logger.info("Call external API");
		ResponseEntity<Comment[]> result = new RestService<Comment[]>().getJson(service,Comment[].class);
		logger.info("Ended Call, Result: {}",result.toString());
		return result;
	}
	
	@RequestMapping("/getComments/{userId}")
	public Comment[] getCommentsTwo(@PathVariable("userId") String id) {
		String url = BASE_URL + "/posts/" + id + "/comments";
		logger.info("Call external API getComments");
		Comment[] comment = new RestTemplate().getForObject(url,Comment[].class);
		logger.info("Ended Call, Result: {}",comment.toString());
		return comment;
	}
	
	@RequestMapping("/getPosts/{userId}")
	public Post getPostsTwo(@PathVariable("userId") String id) {
		String url = BASE_URL + "/posts/" + id;
		logger.info("Call external API getPosts");
		Post post = new RestTemplate().getForObject(url,Post.class);
		logger.info("Ended Call, Result: {}",post.toString());
		logger.info("Ended Call");
		return post;
	}
	
	@RequestMapping("/getUser")
	public TestUser getUser() {
		logger.info("called getUser");
		User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		TestUser user = new TestUser();
		user.setUsername(userAuth.getUsername());
		user.setId();
		logger.info("USER: {}",user.toString());
		return user;
	}

}
