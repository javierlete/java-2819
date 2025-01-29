<%@page import="java.util.ArrayList"%>
<%@page import="tiendaweb.modelos.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
%>
<%@ include file="/vistas/includes/cabecera.jsp" %>

	<h1 class="display-1">Listado</h1>

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

<%@ include file="/vistas/includes/pie.jsp" %>