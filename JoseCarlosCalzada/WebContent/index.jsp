<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Examen JEE</title>
	<link href="https://fonts.googleapis.com/css?family=Special+Elite" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class= "centrar shadow muevet">
		<h3><a href="tabla.jsp">Tabla de Multiplicar</a></h3>
		<h3><a href="circunferencia.jsp">Circunferencia</a></h3>
	</div>
	<p class ="sesion">Id de sesión: <%= session.getId() %></p>
</body>
</html>