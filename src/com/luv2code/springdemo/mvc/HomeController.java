package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String ShowMyPage(){
		System.out.println("main-menu");
	    return "main-menu";
	}
	
	@RequestMapping(value="/hola", method=RequestMethod.GET)
	public String ShowMyPage2(){
	    return "main-menu";
	}
}
