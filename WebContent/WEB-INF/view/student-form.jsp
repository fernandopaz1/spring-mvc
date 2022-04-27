<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!Doctype html>
<html>
<head>
	<title>Student Registration Form</title>
</head>

<body>
	
	<!-- La idea de este formulario es que cuando se carga la vista spring
	va a llamar al metodo get del objeto student en el modelo 
	para llenar los datos del formulario.
	Al apretar submit va a llamar al setter y va a guardar los datos
	en el modelo -->
	
	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName"/>
	
	<br><br>
	
	Last name: <form:input path="lastName"/>
	
	<br><br>
	<form:select path="country">
		
		<!-- Aca le pasamos un linked hashMap -->
		<form:options items="${student.countryOptions }"/>
		
		<%-- 
		Esta es la opcion si se quiere harcodear en la pagina
		de jsp
		
		<form:option value="Brazil" label="Brazil"/>
		<form:option value="France" label="France"/>
		<form:option value="Germany" label="Germany"/>
		<form:option value="India" label="India"/> --%>
	</form:select>
	
	<input type="submit" value="submit">
	</form:form>
</body>
</html>