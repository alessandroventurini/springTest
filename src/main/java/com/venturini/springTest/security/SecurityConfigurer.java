package com.venturini.springTest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.venturini.springTest.service.MyUserDetailService;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailService uds;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
        .withUser("user").password("user").roles("USER")
        .and()
        .withUser("user2").password("user2Pass").roles("USER")
        .and()
        .withUser("admin").password("admin0Pass").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		 .antMatchers(
		            HttpMethod.GET,
		            "/static/**", "/*.js", "/*.json", "/*.ico")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/perform_login")
		.defaultSuccessUrl("/home/")
		.failureUrl("/error/")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/perform_logout")
		.logoutSuccessUrl("/login")
		.permitAll();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
