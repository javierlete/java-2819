<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<%
Cita cita = (Cita) request.getAttribute("cita");
%>

<div class="card" style="width: 18rem;">
	<div class="card-body">
		<h5 class="card-title"><%=cita.getAsunto()%></h5>
		<p class="card-text"><%=cita.getDescripcion()%></p>
	</div>
	<ul class="list-group list-group-flush">
		<li class="list-group-item"><%=cita.getInicio()%></li>
		<li class="list-group-item"><%=cita.getFin()%></li>
		<li class="list-group-item"><%=cita.getPrioridad()%></li>
	</ul>
	<div
		class="card-body d-flex justify-content-between align-items-baseline">
		<a href="borrar?id=<%=cita.getId()%>" class="btn btn-danger">Borrar</a>
		<a href="#" class="card-link"><%=cita.getUsuario().getNombre()%></a> <a
			href="formulario?id=<%=cita.getId()%>" class="btn btn-primary">Editar</a>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>