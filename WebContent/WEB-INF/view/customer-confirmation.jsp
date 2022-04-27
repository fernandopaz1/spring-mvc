<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!Doctype html>
<html>
<head>
	<title>Student Confirmation</title>
</head>

<body>
	<p>The student is confirmed: ${customer.firstName } ${customer.lastName }</p>
	<p>Has ${customer.freePasses } free passes</p>
	<p>Postal code ${customer.postalCode }</p>
	<p>Course code ${customer.courseCode }</p>
</body>
</html>