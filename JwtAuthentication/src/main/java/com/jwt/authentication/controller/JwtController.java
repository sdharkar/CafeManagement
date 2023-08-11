package com.jwt.authentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authentication.model.JwtRequest;
import com.jwt.authentication.model.JwtResponse;
import com.jwt.authentication.service.CustomUserDetailsService;
import com.jwt.authentication.util.JwtUtil;

@RestController
@CrossOrigin
@RequestMapping("/api/jwt/auth")
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	//logger initialization
	Logger logger = LoggerFactory.getLogger(JwtController.class);
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{

	    try {  
	    	logger.debug("generation token");
	    	logger.info("Token generated successfully");
        
		System.out.println(jwtRequest);
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		//fine area
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT "+ token);
		
		//{"Token":"value"}
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	    } catch(Exception e) {
	    	logger.error("Failed to generate token",e);
	    }
		return null;
		
	}

}
