<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Circunferencia</title>
	<link href="https://fonts.googleapis.com/css?family=Special+Elite" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<form action="longarea.jsp" method="get" accept-charset="utf-8" class="shadow muevel">
		<fieldset>
			<legend>Circunferencia</legend>
			<label>Radio de la circunferencia :<input type="number" name="radio"></label>
			<input type="submit" value="Enviar">
		</fieldset>
	</form>
	<p class ="sesion">Id de sesión: <%= session.getId() %></p>
</body>
</html>