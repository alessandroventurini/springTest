package com.venturini.springTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("forward:/index.html");
		registry.addViewController("/error").setViewName("forward:/index.html");
		registry.addViewController("/login").setViewName("forward:/index.html");
	}
}

