<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!Doctype html>
<html>
<head>
	<title>Student Confirmation</title>
</head>

<body>
	<p>The student is confirmed: ${student.firstName } ${student.lastName } from ${student.country }</p>
	<p>His favorite language is ${student.favoriteLanguage }</p>
	
	<br><br>
	Operating Systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>