package com.renting.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MyController {
	
	@GetMapping("/")
	public String main() {
		System.out.println("进入首页========");
		return "login";
	}

}
