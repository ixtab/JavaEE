<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "vivienda.Piso" %>
    <jsp:useBean id="miPiso" class="vivienda.Piso" />
    <jsp:useBean id="miPiso2" class="vivienda.Piso" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Piso</title>
</head>
<body>
	<% 
	miPiso.setMetros(300);
	miPiso2.setColor("Azul");
	Piso miPiso3 = new Piso(7, "Verde", 3, 350);
	%>
	<p>Piso 1: <%= miPiso.toString() %> </p>
	<p>Piso 2: <%= miPiso2.toString() %> </p>
	<p>Piso 3: <%= miPiso3.toString() %> </p>
</body>
</html>