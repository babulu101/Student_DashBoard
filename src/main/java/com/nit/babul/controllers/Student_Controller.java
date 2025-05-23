package com.nit.babul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.babul.entity.Student;
import com.nit.babul.repo.Student_Repo;

@Controller
public class Student_Controller {
	
	@Autowired
	private Student_Repo repo;
	
	@GetMapping("/")
	public String well_come() {
		return "well_come";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("student",new Student());
		return "register";
	}
	@PostMapping("/register")
	public String registered(@ModelAttribute Student student, Model model) {
		repo.save(student);
		model.addAttribute("msg", "Student Register Successfully...");
		return "redirect:/register";
	}
	@GetMapping("/records")
	public String getRecords(Model model) {
		model.addAttribute("record",repo.findAll());
		return "record";
		
		
	}
	
}
