<%@page import="iparlendar.modelos.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cita cita = (Cita) request.getAttribute("cita");
%>
<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IPARLENDAR</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="card" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title"><%=cita.getAsunto()%></h5>
			<p class="card-text"><%=cita.getDescripcion()%></p>
		</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item"><%=cita.getInicio()%></li>
			<li class="list-group-item"><%=cita.getFin()%></li>
			<li class="list-group-item"><%=cita.getPrioridad()%></li>
		</ul>
		<div class="card-body">
			<a href="#"
				class="card-link"><%=cita.getUsuario().getNombre()%></a>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>