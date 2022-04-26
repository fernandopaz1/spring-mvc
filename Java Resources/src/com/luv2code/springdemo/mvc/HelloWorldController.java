package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// control para leer datos de la peticion http, agregar datos
	// al modelo y mostrar la vista con el contenido del modelo
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// Leemos el parametro de la request del formularion http
		String theName = request.getParameter("studentName");	
		// convertimos el parametro a mayusculas
		theName = theName.toUpperCase();		
		// creamos el mensaje
		String result = "Yo! " + theName;
		// agregamos el mensaje al modelo
		model.addAttribute("message", result);		
		
		return "helloworld";
	}

}
