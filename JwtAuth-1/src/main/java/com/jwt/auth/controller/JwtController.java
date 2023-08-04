package com.jwt.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.model.JwtRequest;
import com.jwt.auth.model.JwtResponse;
import com.jwt.auth.service.JwtService;

@RestController
@CrossOrigin
@RequestMapping("/api/jwt/auth")
public class JwtController {
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
	}

}
