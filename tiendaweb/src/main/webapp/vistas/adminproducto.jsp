<%@page import="java.util.ArrayList"%>
<%@page import="tiendaweb.modelos.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Producto producto = (Producto) request.getAttribute("producto");
%>
<%@ include file="/vistas/includes/cabecera.jsp" %>

	<h1 class="display-1">Listado Administración</h1>

	<p><%=producto%></p>

	<form method="post">
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="id" name="id"
					value="<%=producto == null ? "" : producto.getId()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nombre" name="nombre"
					value="<%=producto == null ? "" : producto.getNombre()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm-10">
				<input type="number" step=".01" class="form-control" id="precio" name="precio"
					value="<%=producto == null ? "" : producto.getPrecio()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="descuento" class="col-sm-2 col-form-label">Descuento</label>
			<div class="col-sm-10">
				<input type="number" step=".1" class="form-control" id="descuento" name="descuento"
					value="<%=producto == null ? "" : producto.getDescuento()%>">
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>

<%@ include file="/vistas/includes/pie.jsp" %>