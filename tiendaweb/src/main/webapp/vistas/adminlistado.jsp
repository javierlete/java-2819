<%@page import="java.util.ArrayList"%>
<%@page import="tiendaweb.modelos.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
%>
<%@ include file="/vistas/includes/cabecera.jsp" %>

	<h1 class="display-1">Listado Administración</h1>

	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Descuento</th>
				<th>OPCIONES</th>
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
					<td>
						<a class="btn btn-primary" href="adminproducto?id=<%=p.getId()%>">Editar</a>
						<a class="btn btn-danger" href="adminborrar?id=<%=p.getId()%>">Borrar</a>
					</td>
				</tr>
			<%
			}
			%>
		</tbody>
		
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a class="btn btn-primary" href="adminproducto">Añadir</a>
				</td>
			</tr>
		</tfoot>
	</table>

<%@ include file="/vistas/includes/pie.jsp" %>