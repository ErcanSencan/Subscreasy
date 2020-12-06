package com.subscreasy.subscreasybackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscreasy.subscreasybackend.model.User;
import com.subscreasy.subscreasybackend.service.UserService;







@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService UserService;
	
	@GetMapping
	public ResponseEntity<User> getUSer(){
		return ResponseEntity.ok(UserService.getUser());
	}
	
	@PostMapping
	public ResponseEntity<User> postUser(@RequestBody User user) {
		return ResponseEntity.ok(UserService.postUser(user));

	}
	
}
