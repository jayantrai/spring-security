package com.example.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoding {
	
	@Bean
	public PasswordEncoder passwordEncodeer() {
		return new BCryptPasswordEncoder(10);
	}
}
