package com.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.model.User;
import com.user.management.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	 @PostMapping
	    public User createUser(@RequestBody User user) {
	        return userRepository.save(user);
	    }

	    @GetMapping("/{id}")
	    public User getUserById(@PathVariable String id) {
	        return userRepository.findById(id).orElse(null);
	    }

	    @PutMapping("/{id}")
	    public User updateUser(@PathVariable String id, @RequestBody User user) {
	        user.setId(id);
	        return userRepository.save(user);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable String id) {
	        userRepository.deleteById(id);
	    }

}
