<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.DecimalFormat" %>
<% int radio = Integer.parseInt(request.getParameter("radio"));
	DecimalFormat df = new DecimalFormat("#.00");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Circunferencia con radio <%= radio %></title>
	<link href="https://fonts.googleapis.com/css?family=Special+Elite" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="centrar shadow muever">
		<h3>Circunferencia con radio <%= radio %></h3>
		<h4>Longitud: <%= df.format(2 * Math.PI * radio) %></h4>
		<h4>Area: <%=  df.format(Math.PI * (radio * radio)) %></h4>
		<p class ="sesion">Id de sesión: <%= session.getId() %></p>
	</div>
</body>
</html>