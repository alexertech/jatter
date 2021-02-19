package com.alexertech.jatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PagesController {

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

}
