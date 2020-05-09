package com.example.springsecurity.auth;

import java.util.Optional;


// we are implememting ApplicationUser class which was created
public interface ApplicationUserDAO {
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
