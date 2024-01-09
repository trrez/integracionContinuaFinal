<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>PetSmile</title>
	<link rel="stylesheet" type="text/css" href="css/styles-index.css">
</head>
<body>
	<nav>
		<h1>PetSmile</h1>
		<h2>Bienvenid@, <%= session.getAttribute("nombreUsuario") %></h2>
	</nav>
	<div>
		<button onclick="window.location.href='agendar.jsp'" id="agendarHorabtn" class="agendarHorabtn">Agendar hora</button>
	</div>
</body>
</html>