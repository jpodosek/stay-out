package com.libertymutual.goforcode.stayout.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	
	Model model;
	
	@GetMapping("")
	public String unsecured() {
		return "unsecured";
	}
	
	@GetMapping("loginalot")
	public String login() {
		return "loginalot";
	}
	
	@GetMapping("secured")
	public String secured() {
	
		return "secured";
	}
	
	@GetMapping("/admin")
	public String admin() {
		
		return "admin";
	}
	
	
	
}
