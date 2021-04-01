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
	
	@GetMapping("/")
	public String index(Model model) {
		List<Jeet> issues = service.GetAll();
		model.addAttribute("issuesList", issues);
		return "index";
	}
	
	@GetMapping("/issue/list")
	public String list(Model model) {
		List<Jeet> issues = service.GetAll();
		model.addAttribute("issuesList", issues);
		return "issue_index";
	}
	
	@GetMapping("/issue/add")
	public String add(Model model) {

		model.addAttribute("issuesForm", new Jeet());
		return "issue_form"; 
	}
	@PostMapping("/issue/save")
	public String save(Jeet i, Model model) {
		service.Save(i);
		return "redirect:/issue/list";
	}
	
	@GetMapping("/issue/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Jeet> issue = service.GetId(id); 
		model.addAttribute("issuesForm",issue);
		return "issue_form";
	}
	
	@GetMapping("/issue/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.Delete(id);
		return "redirect:/issue/list";
	}

}