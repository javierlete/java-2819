<%@page import="tiendaweb.modelos.Usuario"%>
<%@page import="tiendaweb.controladores.Autorizacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
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
<body>
	<nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">TiendaWeb</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="listado">Listado</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<%
					if (Autorizacion.esAdmin(request)) {
					%>
					<li class="nav-item"><a class="nav-link" href="adminlistado">Administración</a></li>
					<%
					}
					if (!Autorizacion.estaAutenticado(request)) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Iniciar
							sesión</a></li>
					<%
					} else {
					%>
					<li class="navbar-text"><%=usuario.getEmail()%> <%=usuario.getRol()%></li>
					<li class="nav-item"><a class="nav-link" href="logout">Cerrar
							sesión</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<main class="container">