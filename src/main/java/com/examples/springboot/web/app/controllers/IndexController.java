package com.examples.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examples.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("title", "How to put a data from controller.");
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		User user = new User("Raul","Sulca Palacios","rar@com");
		model.addAttribute("user",user);
		return "profile";
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<User>> getUsers(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User("Raul","Sulca Palacios","ra2r@com"));
		list.add(new User("Roxana","Sulca Palacios","ra3r@com"));
		list.add(new User("Jimena","Sulca Palacios","rard@com"));
		model.addAttribute("users",list);
		return new ResponseEntity<>( list , HttpStatus.OK);
	}
	
}
