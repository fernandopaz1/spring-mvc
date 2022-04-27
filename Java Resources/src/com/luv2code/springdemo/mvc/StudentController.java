package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@Value("#{languagesOptions}") 
	private Map<String, String> languagesOptions;
	
	@Value("#{operatingSystemOptions}") 
	private Map<String, String> operatingSystemOptions;
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Student theStudent = new Student();
		
		model.addAttribute("student",theStudent);
		
		 // add the country options to the model 
	    model.addAttribute("theCountryOptions", countryOptions); 
	    
	    model.addAttribute("theLanguageOptions", languagesOptions); 
	    
	    model.addAttribute("theOperatingSystemOptions", operatingSystemOptions);

		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("The student is: " + theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student-confirmation";
	}

}
