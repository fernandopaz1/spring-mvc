package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Student theStudent = new Student();
		
		model.addAttribute("student",theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("The student is: " + theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student-confirmation";
	}

}
