<%@page import="iparlendar.modelos.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Cita> citas = (ArrayList<Cita>) request.getAttribute("citas");
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
	<table class="table table-bordered">
		<tbody>
			<%
			for (Cita cita : citas) {
			%>
			<tr>
				<td><%=cita.getAsunto()%></td>
				<td><%=cita.getInicio()%></td>
				<td><%=cita.getFin()%></td>
				<td><%=cita.getDescripcion()%></td>
				<td><%=cita.getPrioridad()%></td>
				<td><%=cita.getUsuario().getNombre()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>