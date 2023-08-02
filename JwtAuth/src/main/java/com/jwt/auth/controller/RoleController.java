package com.jwt.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.model.Role;
import com.jwt.auth.services.RoleService;

@RestController
@CrossOrigin
@RequestMapping("/api/jwt/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}

}
