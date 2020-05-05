package com.example.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;




@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder)  {
		this.passwordEncoder = passwordEncoder;
	}
	

	// overriding parent super class using http configure 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 	.authorizeRequests()
				.antMatchers("/", "index", "/css/*", "/js/*")
				.permitAll()
				.antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name())
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic(); // it means basic auth
		
		
	}


	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		// retrieve users from the database
		UserDetails raijayantUser = User.builder()
			.username("raijayant")
			.password(passwordEncoder.encode("password"))
			.roles("STUDENT") // Role_Student
			.build();
		
		UserDetails jirelKalpanaUser =  User.builder()
			.username("jirelkalpana")
			.password(passwordEncoder.encode("123"))
			.roles(ApplicationUserRole.ADMIN.name()) // role admin
			.build();
		
		UserDetails tomUser =  User.builder()
				.username("tom")
				.password(passwordEncoder.encode("123"))
				.roles(ApplicationUserRole.ADMINTRAINEE.name()) // role admin_trainee
				.build();
		
		return new InMemoryUserDetailsManager(
				raijayantUser, 
				jirelKalpanaUser,
				tomUser
				);
	}
	
}
