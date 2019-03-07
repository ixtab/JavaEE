<%@page import="datos.LogicaBD"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	ServletContext contextoAplicacion = this.getServletContext();
	LogicaBD logicaBD = (LogicaBD) contextoAplicacion.getAttribute("miLogicaBD");
%>
<p>	<a href="CerrarSesion">Cerrar sesi�n</a></p>
<h1>Usuario: <%= n%></h1>
<p>	<a href="Gestion?accion=Home">Atr�s</a></p>
<p>	<a href="Gestion?accion=Inventario">Inventario</a></p>
<p>	<a href="Gestion?accion=Clientes">Clientes</a></p>
<p>	<a href="Gestion?accion=Facturas">Facturas</a></p>
<h1>Inventario de la ferreter�a</h1>
	<% ResultSet rs = logicaBD.inventario(); 
		String linea = "<p>";
		rs.beforeFirst();
		while ( rs.next() ){
			double total = rs.getDouble("PRECIO") *  rs.getInt("STOCK");
			linea += "C�digo: " + rs.getString("CODIGO") + ".- ";
			linea += "Descipci�n: " + rs.getString("DESCRIPCION") + ".- ";
			linea += "Precio: " + rs.getString("PRECIO") + ".- ";
			linea += "Stock: " + rs.getString("STOCK") + ".- ";
			linea += "Total: " + total + "</p>";
		}%>
	<%= linea %>
	
</body>
</body>
</html>