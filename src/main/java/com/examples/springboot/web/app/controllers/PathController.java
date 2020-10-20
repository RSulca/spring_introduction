package com.examples.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path")
public class PathController {

	@GetMapping("/string/{text}")
	public String path(@PathVariable String text, Model model) {
		model.addAttribute("title", "String path");
		model.addAttribute("text", "El contenido ingresado es: " + text);
		return "path/show";
	}
	
	@GetMapping("/string/{text}/{number}")
	public String path(@PathVariable String text,@PathVariable Integer number, Model model) {
		model.addAttribute("title", "String path");
		model.addAttribute("text", "El contenido ingresado es: " + text+" y el numero es "+number);
		return "path/show";
	}
	
	
}
