package com.alexertech.jatter.jeet;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JeetController {
	
	@Autowired
	private JeetInterface service;
	
	@GetMapping("/jeet")
	public String index(Model model) {
		List<Jeet> issues = service.GetAll();
		model.addAttribute("jeetList", issues);
		return "jeet_index";
	}
	
	@GetMapping("/jeet/list")
	public String list(Model model) {
		List<Jeet> issues = service.GetAll();
		model.addAttribute("jeetList", issues);
		return "jeet_index";
	}
	
	@GetMapping("/jeet/add")
	public String add(Model model) {

		model.addAttribute("jeetForm", new Jeet());
		return "jeet_form"; 
	}
	@PostMapping("/jeet/save")
	public String save(Jeet i, Model model) {
		service.Save(i);
		return "redirect:/jeet/list";
	}
	
	@GetMapping("/jeet/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Jeet> issue = service.GetId(id); 
		model.addAttribute("jeetForm",issue);
		return "jeet_form";
	}
	
	@GetMapping("/jeet/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.Delete(id);
		return "redirect:/jeet/list";
	}

}