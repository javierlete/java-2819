<%@page import="modelos.Monitor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Monitor> monitores = (ArrayList<Monitor>) request.getAttribute("monitores");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado</title>

<link rel="stylesheet" href="css/listado.css">

</head>
<body>

	<h1>Listado</h1>

	<form>
		<input name="color" placeholder="Color por el que quieres filtrar">
		<button>Buscar</button>
	</form>

	<table>
		<caption>Listado de monitores</caption>

		<thead>
			<tr>
				<th>Id</th>
				<th>Ancho</th>
				<th>Alto</th>
				<th>Diagonal</th>
				<th>Color</th>
				<th>Número pixels</th>
				<th>OPCIONES</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (Monitor m : monitores) {
			%>
			<tr>
				<td><%=m.getId()%></td>
				<td><%=m.getAncho()%></td>
				<td><%=m.getAlto()%></td>
				<td><%=m.getDiagonal()%></td>
				<td><%=m.getColor()%></td>
				<td><%=m.getNumeroPixels()%></td>
				<td><a href="">Editar</a> <a href="">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

		<tfoot>
			<tr>
				<td colspan="6"></td>

				<td><a href="formulario.jsp">Añadir</a></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>