package com.alexertech.jatter.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * The UserController Class handles all the request and interactions related to the 
 * Users. Allows listing, update, delete among other operations over the data.
 * */

@Controller
@RequestMapping
public class UsersController{

	@Autowired
	private UsersRepository service;
	
	// Set up the Bcrypt encoder to handle the passwords
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/user/list")
	public String list(Model model) {
		List<Users> users = service.findAll();
		model.addAttribute("usersList", users);
		return "user_index";
	}

	// --------------------------------------
	
	// Adding a record
	@GetMapping("/register")
	public String add(Model model) {
		// "model" is our way to send information to the view using thymeleaf.
		// In this case we are setting a new User object.
		model.addAttribute("usersForm", new Users());
		
		// Return the user_form view
		return "user_form"; 
	}
	
	// Saving the record
	@PostMapping("/register/save")
	public String save(Users i, Model model) {
		// First we receive the user post information from the form in the object "i"
		// Extract the password from the submission for encoding
		String encPass =  bCryptPasswordEncoder.encode(i.getPassword());
		
		// And then, save in the same object the password encrypted
		i.setPassword(encPass);
		
		// Using the service class connected to the users repository we can save the 
		// new user.
		service.save(i);
		
		// Return the user_index view
		return "user_index";
	}
	
	// Process login action
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usersForm",new Users());
		return "login"; 
	}
	
	// Process login error
	@GetMapping("/login-error")
	public String login_error(Model model) {
		model.addAttribute("usersForm",new Users());
		model.addAttribute("loginError",true);
		return "login"; 
	}	
	
}

