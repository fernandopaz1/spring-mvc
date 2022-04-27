package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// La clase que usamos para validar tiene que implementar la interfaz
// ConstraintValidator<annotation, tipo de dato a validar>
public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode,String>{

	private String coursePrefix;
	
	// al inicializar reemplazamos el parametro que se le pasa
	// a la annotation
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	// Logica de negocio, si empieza con el parametro que le pasamos a la annotation
	// entonces es valido
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result = theCode.startsWith(coursePrefix);
		
		return result;
	}

	
	
}
