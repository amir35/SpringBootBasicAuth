package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	
	@GetMapping("/basicauth")
	@CrossOrigin
	public String doLogin()
	{
		return "Authenticated successfully";
	}

}
