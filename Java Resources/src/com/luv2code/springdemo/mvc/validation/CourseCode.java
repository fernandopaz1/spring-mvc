package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// En constraint pasamos la clase que tiene el metodo validador
// Target nos dice sobre en donde se puede usar esta annotation (campos, metodos...)
// Retention no dice cuando se descarta la annotation:
// RetentionPolicy.SOURCE: se retiene en el codigo fuente y se descarta durante la compilacion
// RetentionPolicy.CLASS: se retiene hasta que se compila el codigo y se descarta durante el runtime
// RetentionPolicy.RUNTIME: esta disponible en la JVM durante runtime
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	// definimos el codigo del curso por default
	public String value() default "LUV";
	
	// definimos el mensaje de error por default
	public String message() default "must start with LUV";
	
	// default groups
	public Class<?>[] groups() default {};
	
	// default payloads
	public Class<? extends Payload>[] payload() default {};	
	
	
}
