package com.alexertech.jatter.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UsersController{

	@Autowired
	private UsersRepository service;
	
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/user/list")
	public String list(Model model) {
		List<Users> users = service.findAll();
		model.addAttribute("usersList", users);
		return "user_index";
	}

	// --------------------------------------
	
	@GetMapping("/user/add")
	public String add(Model model) {
		model.addAttribute("usersForm", new Users());
		model.addAttribute("formAction", "save");
		return "user_form"; 
	}
	
	@PostMapping("/user/save")
	public String save(Users i, Model model) {
		String encPass =  bCryptPasswordEncoder.encode(i.getPassword());
		i.setPassword(encPass);
		service.save(i);
		return "redirect:/user/list";
	}
	
}

