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
<title>Listado</title>
</head>
<body>

	<h1>Listado</h1>

	<ul>
		<%
		for (Producto p : productos) {
		%>
		<li><%= p.getNombre() %>: <%= p.getPrecio() %>€
			<img src="imgs/<%=p.getId()%>.jpg" alt="">
		</li>
		<%
		}
		%>
	</ul>

	<!-- <p><%=productos%></p> -->

</body>
</html>