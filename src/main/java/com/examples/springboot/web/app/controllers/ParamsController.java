package com.examples.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	@GetMapping("/string")
	public String paramString(@RequestParam(required = false, defaultValue = "raaa") String text, Model model) {
		model.addAttribute("title", "String param");
		model.addAttribute("text", "El texto ingresado es: " + text);
		return "params/show";
	}

	@GetMapping("/mix-params-requestParam")
	public String paramString(@RequestParam String text, @RequestParam Integer number, Model model) {
		model.addAttribute("title", "Mix params");
		model.addAttribute("text", "El texto ingresado es: '" + text + " ', y el numero es '" + number + " '");
		return "params/show";
	}
	
	@GetMapping("/mix-params-servlet")
	public String paramString(HttpServletRequest request, Model model) {
		String text = request.getParameter("text");
		Integer number = null;
		try {
			number = Integer.parseInt(request.getParameter("number"));
		}catch(NumberFormatException e) {
			number = 0;
		}
		model.addAttribute("title", "Mix params");
		model.addAttribute("text", "El texto ingresado es: '" + text + " ', y el numero es '" + number + " '");
		return "params/show";
	}
}
