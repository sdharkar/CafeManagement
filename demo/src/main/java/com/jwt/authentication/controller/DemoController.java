package com.jwt.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
	
	@GetMapping
	public String sendMsg() {
		return "this is deom controller";
		
	}
	

}
