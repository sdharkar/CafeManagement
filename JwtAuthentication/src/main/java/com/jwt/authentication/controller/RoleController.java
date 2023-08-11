package com.jwt.authentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/api/jwt/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	//logger initialization
	Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@PostMapping
	public Role createNewRole(@RequestBody Role role) {
        try {
        	logger.debug("creating role");
            logger.info("Role created successfully");
            return roleService.createNewRole(role);
        } catch(Exception e) {
        	logger.error("Failed to create role", e);
        }
		return role;
	}

}
