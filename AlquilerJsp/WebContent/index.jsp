<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.text.DecimalFormat" %>
<!DOCTYPE html>
<html lang = "es">
<head>
<meta charset="UTF-8">
<title>Alquiler de Viviendas</title>
<style type="text/css" media="screen">
	body{
		text-align: center;
		animation-name: fondo;
		animation-duration: 60s;
		animation-iteration-count: infinite;
		animation-direction: alternate;
	}
	form {
		width: 33%;
		margin-left: 33%;
		
	}
	input, select, option {
	background: rgba(255, 255, 255, 0.5);
	}
	
	@keyframes fondo{
		50%{background-color: #ccffee;}
	}
	
</style>
</head>
<body>
	<%
		double precio = 0;
		double mejoras = 0;
		
		DecimalFormat df = new DecimalFormat("#,##0.00"); 
		if(request.getParameter("sitio")!=null) precio = Double.parseDouble(request.getParameter("sitio")) * Double.parseDouble(request.getParameter("metros"));
		if (request.getParameter("cale") != null) mejoras = mejoras + Double.parseDouble(request.getParameter("cale"));
		if (request.getParameter("pisci") != null) mejoras = mejoras + Double.parseDouble(request.getParameter("pisci"));
		if (request.getParameter("aire") != null) mejoras = mejoras + Double.parseDouble(request.getParameter("aire"));
		precio = precio + precio * mejoras / 100;
		if (request.getParameter("paro") != null) precio = precio - (precio * Double.parseDouble(request.getParameter("paro"))/100);
	
	%>

	<form method="get" accept-charset="utf-8">
		<fieldset>
			<legend>Calcula el precio de tu vivienda</legend>
			<div>
			<p>Localidad: <select name="sitio">
				<option value="20">Leganés (20€/m)</option>
				<option value="15">Fuenlabrada (15€/m)</option>
				<option value="14">Móstoles (14€/m)</option>
				<option value="21">Alcorcón (21€/m)</option>
			</select></p>
			
			<p>Tamaño: <input type="number" name="metros" placeholder="Metros cuadrados" min = "10" required></p>
			<p>
				<label><input type="checkbox" name="cale" value="3"> Calefacción</label> <!-- El valor es el %  que aumenta el precio-->
				<label><input type="checkbox" name="pisci" value="3"> Piscina</label>
				<label><input type="checkbox" name="aire" value="3"> Aire Acondicionado</label>
			</p>

			<p>
				<label>¿Está en paro?
					<input type="radio" name="paro" value="4"> Si <!-- El valor es el % que reduce el precio -->
					<input type="radio" name="paro" value="0" checked> No
				</label>
			</p>			
			<p>
				<input type="submit" name="boton" value="Consultar">
			</p>
		</div>
		</fieldset>
	</form>
		<% if (precio != 0) {%>
			<h1>El Precio de la vivienda es: <%= df.format(precio) %>€</h1>
		<%}%>
</body>
</html>