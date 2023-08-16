package com.jwt.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.authentication.model.Role;
import com.jwt.authentication.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	//creating new role
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
	}

}
