package com.example.springsecurity.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.security.ApplicationUserRole;
import com.google.common.collect.Lists;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDAO {
	
	private final PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		// TODO Auto-generated method stub
		return getApplicationUsers().stream().filter(applicationUsers -> username.equals(applicationUsers.getUsername()))
									.findFirst();
	}
	
	// create a method 
	
	private List<ApplicationUser> getApplicationUsers() {
		List<ApplicationUser> applicationUsers = Lists.newArrayList(
				new ApplicationUser(ApplicationUserRole.STUDENT.getGrantedAuthorities(), "raijayant",  passwordEncoder.encode("password"), true, true, true, true),
				new ApplicationUser(ApplicationUserRole.ADMIN.getGrantedAuthorities(), "jirelkalpana",  passwordEncoder.encode("password"), true, true, true, true),
				new ApplicationUser(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(), "tom",  passwordEncoder.encode("password"), true, true, true, true)
				
				
				);
				
				
		
		return applicationUsers;
	
	}
	

	
}
