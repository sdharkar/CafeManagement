package com.jwt.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authentication.model.JwtRequest;
import com.jwt.authentication.model.JwtResponse;
import com.jwt.authentication.service.JwtService;

@RestController
@CrossOrigin
public class JwtController {
	
	 	@Autowired
	    private JwtService jwtService;

	    @PostMapping({"/authenticate"})
	    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	    	try {
	    		System.out.println("JWT token created successfully");
	        return jwtService.createJwtToken(jwtRequest);
	    	} catch(Exception e) {
	    		System.out.println("Failed to create JWT token");
	    	}
			return null;
	    }

}
