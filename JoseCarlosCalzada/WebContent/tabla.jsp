<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabla de Multiplicar</title>
<link href="https://fonts.googleapis.com/css?family=Special+Elite" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<form action="Tabla" method="get" accept-charset="utf-8" class="shadow muevel">
		<fieldset>
			<legend>Tabla de Multiplicar</legend>
			<label>Número para obtener la tabla :<input type="number" name="numero"></label>
			<input type="submit" value="Enviar">
		</fieldset>
	</form>
	<p class ="sesion">Id de sesión: <%= session.getId() %></p>
</body>
</html>