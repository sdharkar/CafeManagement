package com.jwt.auth.configuration;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;

import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	public void commence(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException authException) throws IOException, ServletException{
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}

   
}




