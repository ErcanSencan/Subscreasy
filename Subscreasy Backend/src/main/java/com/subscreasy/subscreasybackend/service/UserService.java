package com.subscreasy.subscreasybackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.subscreasy.subscreasybackend.enums.RoleType;
import com.subscreasy.subscreasybackend.model.Role;
import com.subscreasy.subscreasybackend.model.User;
import com.subscreasy.subscreasybackend.repository.RoleRepository;
import com.subscreasy.subscreasybackend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	private BCryptPasswordEncoder byBCryptPasswordEncoder;
	
	public UserService() {
		this.byBCryptPasswordEncoder = new BCryptPasswordEncoder();
	}
	
	public User getUser() {
		String authicatedUserName = getAuthenticatedUserName();
		User user = userRepository.findByUserName(authicatedUserName);
		user.setPassword(null);
		return user;
	}
	
	public User postUser(User user) {
		user.setPassword(byBCryptPasswordEncoder.encode(user.getPassword()));
        Role role = this.roleRepository.findByName(RoleType.ROLE_USER);
		user.setRole(role);
		user.setActive(true);
		user.setId(-1);
		return userRepository.save(user);
	}
	
	private String getAuthenticatedUserName() {
		return (String) SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
