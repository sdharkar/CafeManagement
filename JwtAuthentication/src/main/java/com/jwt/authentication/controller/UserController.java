package com.jwt.authentication.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/jwt/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//logger initialization
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUsers();
	}
	
	@PostMapping
	public User registerNewUser(@RequestBody User user) {
        try {
        	logger.debug("Reguresting new user");
            logger.info("New user registured successfully");
            return userService.registerNewUser(user);
        } catch(Exception e) {
        	logger.error("Failed to register new", e);
        }
		return user;
	}

	@GetMapping("/foradmin")
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
        try {
        	logger.debug("Displaying admin access");
            logger.info("Admin access displayed successfully");
            return "This URL is only accessible to admin";
        } catch(Exception e) {
        	logger.error("Failed to display admin access", e);
        }
		return null;
	}
	
	@GetMapping("/foruser")
	@PreAuthorize("hasRole('User')")
	public String forUser() {
        try {
        	logger.debug("Displaying user access");
            logger.info("User access displayed successfully");
            return "This URL is only accessible to user";
        } catch(Exception e) {
        	logger.error("Failed to display user access", e);
        }
		return null;
	}
	
	
}