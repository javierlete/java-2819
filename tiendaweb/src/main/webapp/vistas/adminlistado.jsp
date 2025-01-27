<%@page import="java.util.ArrayList"%>
<%@page import="tiendaweb.modelos.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
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

	<h1 class="display-1">Listado Administración</h1>

	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Descuento</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (Producto p : productos) {
			%>
				<tr>
					<td><%=p.getId() %></td>
					<td><%=p.getNombre() %></td>
					<td><%=p.getPrecio() %></td>
					<td><%=p.getDescuento() %></td>
				</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>