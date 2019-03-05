<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.Random" %> <!-- Esto es una directiva y lo de arriba tambi�n --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--Declaraci�n, lo que se declara aqu� se mantiene para todas las sesiones (durante toda la sesion del servidor). No muestra nada-->
<%!
	int contador = 0;  
	String frase;
	double aleatorio = Math.random();
%>
<% // Aqu� se va a mantener siempre el valor de aleatorio para todas las sesiones
	
	if (aleatorio < 0.5){
		frase = "Adios";
	} else {
		frase = "Hola";
	}
%>

<H1>EXPRESIONES JSP</H1> <!-- Muetra lo que se pone -->
<p><%= 2*30*java.lang.Math.PI%></p>  
<p><%= new java.util.Date()%></p>
<p><%= request.getRemoteHost()%></p>
<p><%= session.getId()%></p>


<H1>Scriptlets</H1>  <!-- Se ejecuta una vez por cada requerimiento, no muestra nada -->
	<%
		double precio=10;
		int cantidad=5;
		String producto="Peras";
		double subtotal=precio*cantidad;
		double iva=subtotal*0.16;
		double total=subtotal+iva;
		contador ++;  // Se coge la variable de la declaraci�n-
	%>
	<p>Nombre art�culo:<%= producto %> </p>
	<p>Precio art�culo:<%= precio %> </p>
	<p>Subtotal: <%= subtotal%> </p>
	<p>Total IVA incluido: <%= total %> </p>
	<p> Acessos a la p�gina: <%= contador %> </p>
	
<p><%= aleatorio +": " +frase%></p>

<% if (Math.random()<0.5) 
	{ %>
		<H2>VAS A TENER UN BUEN DIA</H2>
		<H3>FELICIDADES</H3>
	<% }
	else
	{ %>
		<H2>VAS A TENER UN MAL DIA</H2>
		<H2>PODRIA SER PEOR</H2>
	<% } %>

	

</body>
</html>
