package com.amit.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping
	public String welcome(Model model, RedirectAttributes redirectAttribute)
	{
		model.addAttribute("greeting","Welcome to Web Store");
		model.addAttribute("tagline", "The one and only Amazing Web store");
		
		return "welcome";
	}
	
	

}
