package com.tranduylinh.NhaTro.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tranduylinh.NhaTro.models.Role;
import com.tranduylinh.NhaTro.models.User;

public interface UserService extends UserDetailsService{
	User saveUser(User user);
	Role saveRole(Role role);
	void addToUser(String username, String rolename);
	User findUserByUserName(String userName);

}
