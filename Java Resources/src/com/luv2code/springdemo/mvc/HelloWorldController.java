package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// metodo controller para mostrar el formulario inicial
	@RequestMapping("/showForm")
	public String ShowForm(){
		System.out.println("ShowForm");
	    return "helloworld-form";
	}

	// metodo controller para procesar el formulario
	@RequestMapping("/processForm")
	public String ProcessForm() {
		System.out.println("ProcessForm");
		return "helloworld";
	}

}
