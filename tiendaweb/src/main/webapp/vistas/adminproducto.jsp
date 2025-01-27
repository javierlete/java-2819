<%@page import="java.util.ArrayList"%>
<%@page import="tiendaweb.modelos.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Producto producto = (Producto) request.getAttribute("producto");
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

	<p><%=producto%></p>
	
	<form>
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="id" value="<%=producto.getId()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nombre" value="<%=producto.getNombre()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm-10">
				<input type="number" step=".01" class="form-control" id="precio" value="<%=producto.getPrecio()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="descuento" class="col-sm-2 col-form-label">Descuento</label>
			<div class="col-sm-10">
				<input type="number" step=".1" class="form-control" id="descuento" value="<%=producto.getDescuento()%>">
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>
</body>
</html>