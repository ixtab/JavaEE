<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="datos.LogicaBD" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventario de art�culos</title>
</head>
<body>
<%
	String n = request.getParameter("nombre");
	if (n==null) {
		HttpSession sesion = request.getSession(true);
		n = (String) sesion.getAttribute("nombre");
	}
%>
<p>	<a href="CerrarSesion">Cerrar sesi�n</a></p>
<h1>Usuario: <%= n%></h1>
<p>	<a href="Gestion?accion=Home">Atr�s</a></p>
<p>	<a href="Gestion?accion=Inventario">Inventario</a></p>
<p>	<a href="Gestion?accion=Clientes">Clientes</a></p>
<p>	<a href="Gestion?accion=Facturas">Facturas</a></p>
<%= LogicaBD.tablaClientes() %>
</body>
</body>
</html>