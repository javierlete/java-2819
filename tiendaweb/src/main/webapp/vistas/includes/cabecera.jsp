<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = (String) session.getAttribute("email");
String ip = (String) session.getAttribute("ip");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TiendaWeb</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<!-- Fin Bootstrap -->
</head>
<body class="container">

	<header>
		<h2><%=email %></h2>
		<h2><%=ip %></h2>
	</header>
	
	<nav>
		<ul>
			<li><a href="listado">Listado</a></li>
			<li><a href="adminlistado">Administración listado</a></li>
			<li><a href="adminproducto">Administración producto</a></li>
			<li><a href="login">Iniciar sesión</a></li>
			<li><a href="logout">Cerrar sesión</a></li>
		</ul>
	</nav>