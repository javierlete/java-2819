<%@page import="java.util.ArrayList"%>
<%@page import="tiendaweb.modelos.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");

String email = (String) session.getAttribute("email");
String ip = (String) session.getAttribute("ip");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listado</title>

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

	<h1 class="display-1">Listado</h1>

	<h2><%=email %></h2>
	<h2><%=ip %></h2>

	<div class="row row-cols-1 row-cols-md-3 g-4">
		<%
		for (Producto p : productos) {
		%>
		<div class="col">
			<div class="card h-100">
				<img src="imgs/<%=p.getId()%>.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title"><%=p.getNombre()%></h5>
					<p class="card-text">
						Precio:
						<%=p.getPrecio()%>€
					</p>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary"><%=p.getDescuento()%>%</small>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>

	<!-- <p><%=productos%></p> -->

</body>
</html>