package com.subscreasy.subscreasybackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/logincheck")
public class LoginController {
	
	@GetMapping
	public boolean isLoggin() {
		return true;
	}
}
