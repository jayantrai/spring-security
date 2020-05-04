package com.example.springsecurity.security;

import java.util.Set;
import com.google.common.collect.*;
import static com.example.springsecurity.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));
	
	private final Set<ApplicationUserPermission> permissions;

	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}
	
	
	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
}
