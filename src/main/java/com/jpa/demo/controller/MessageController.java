package com.jpa.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
	@GetMapping("/getMessage")
	public String showMessage(Model model) {
		
		model.addAttribute("message","Spring Welcomes you to its Web MVC World");
		return "Display";
	}
	
	

}
