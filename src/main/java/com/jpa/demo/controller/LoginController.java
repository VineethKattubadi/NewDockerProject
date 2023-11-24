package com.jpa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.demo.dto.Users;
import com.jpa.demo.repository.UsersRepository;

@Controller
public class LoginController {
	@Autowired
	UsersRepository userRepository;

	@GetMapping("/loginPage")
	public String getLoginPage() {

		return "login";
	}
//	
//	@PostMapping("/authenticate")
//	public String authenticateUser(@RequestParam("uname") String username, @RequestParam("pword") String password) {
//		String message = "Invalid Username/Password............Try Again....!";
//		if (username.equalsIgnoreCase("Vinee") && password.equals("Vinee@3124"))
//			message = "Welcome mr.Vinee";
//			return new  ModelAndView("Display","message",message);


	// @GetMapping("/authenticate")
	@PostMapping("/authenticate")
	public String authenticate(@RequestParam("uname") String username, @RequestParam("pword") String password,
			Model model) {
	String message = "Invalid User ............Try Again....!";
	Users u = new Users(username,password);
		//if (username.equalsIgnoreCase("Vinee") && password.equals("Vinee@3124"))
		//message = "Welcome mr.Vinee";
	
		if(userRepository.authenticate(u))
			return "UserCrud";
//			message= "Welcome mr. vinee";
//		model.addAttribute("message",message);
model.addAttribute("message", message);
	return "Display";

	}
	@GetMapping("/addUser")
	public String addUserDetails(@RequestParam("uname")String username,@RequestParam("pword")String password,Model model) {
		Users u = new Users(username,password);
		String message="UserDetails instruction failed";
		if(userRepository.addUser(u))
			message="UserDetails Insereted Successfully";
		model.addAttribute("message", message);
			return "Display";
		
	}

}
