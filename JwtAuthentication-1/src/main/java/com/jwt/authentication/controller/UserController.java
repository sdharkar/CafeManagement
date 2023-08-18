package com.jwt.authentication.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authentication.model.User;
import com.jwt.authentication.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initRolesAndUsers() {
		try {
			System.out.println("Init roles and users successfully");
		userService.initRolesAndUsers();
		}catch(Exception e) {
			System.out.println("Failed to init Roles and Users");
		}
	}
	
	@PostMapping("/register")
	public User registerNewUser(@RequestBody User user) {
		try {
			System.out.println("New user is registered successfully");
		return userService.registerNewUser(user);
		} catch(Exception e) {
			System.out.println("Failed to register new user");
		}
		return user;
	}

	@GetMapping("/foradmin")
//	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only accessible to admin";
	}
	
	@GetMapping("/foruser")
//	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only accessible to user";
	}

}
