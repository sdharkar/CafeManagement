package com.jwt.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.model.User;
import com.jwt.auth.services.UserService;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin
@RequestMapping("/api/jwt/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUsers();
	}
	
	@PostMapping
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	@GetMapping("{/foradmin}")
	public String forAdmin() {
		return "This URL is only accessible to admin";
	}
}
