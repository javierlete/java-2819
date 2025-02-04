<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="iparlendar.modelos.Usuario"%>
<%@page import="iparlendar.modelos.Cita"%>
<%@page import="java.util.ArrayList"%>
<%
Usuario usuarioLogin = (Usuario) session.getAttribute("usuario");
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

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="citas">Iparlendar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="citas">Citas</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<%
					if (usuarioLogin == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Iniciar
							sesión</a></li>
					<%
					} else {
					%>
					<li class="navbar-text"><%=usuarioLogin.getNombre()%></li>
					<li class="nav-item"><a class="nav-link" href="logout">Cerrar
							sesión</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>