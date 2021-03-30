package com.alexertech.jatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * The PageController Class handles all the request for single pages
 * which provide static information (I.E.: about us, help)
 * */

@Controller
@RequestMapping
public class PagesController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Main :: Jatter");
		return "index";
	}

}
