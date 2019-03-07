<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceso al programa</title>
<style>
	img {
			position: fixed;
			bottom: 0;
			right: 0;
	}
</style>
</head>
<body>
<%
	String n = request.getParameter("nombre");
	if (n==null) {
		HttpSession sesion = request.getSession(true);
		n = (String) sesion.getAttribute("nombre");
	}
%>
<p>	<a href="CerrarSesion">Cerrar sesión</a></p>
<h1>Usuario: <%= n%></h1>
<p>	<a href="Gestion?accion=Home">Home</a></p>
<p>	<a href="Gestion?accion=Inventario">Inventario</a></p>
<p>	<a href="Gestion?accion=Clientes">Clientes</a></p>
<p>	<a href="Gestion?accion=Facturas">Facturas</a></p>
<img src="imagenes/herramientas.jpg" alt="Herramientas" />
</body>
</html>