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
					if (email != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="adminlistado">Administración</a></li>
					<%
					} else {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Iniciar
							sesión</a></li>
					<%
					}
					if (email != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="logout">Cerrar
							sesión</a></li>
					<li class="navbar-text"><%=email%></li>
					<li class="navbar-text ms-2"><%=ip%></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<main class="container">