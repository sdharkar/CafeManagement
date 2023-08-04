package com.jwt.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.auth.model.Role;
import com.jwt.auth.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating new role
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
	}

}
