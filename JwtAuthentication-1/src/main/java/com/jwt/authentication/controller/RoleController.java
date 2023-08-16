package com.jwt.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authentication.model.Role;
import com.jwt.authentication.service.RoleService;

@RestController
@CrossOrigin
@RequestMapping("/cafe/jwt/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/create")
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}

}
