<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>

<h1>Cita</h1>

<form class="container" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" id="id" name="id">
		</div>
	</div>
	<div class="row mb-3">
		<label for="asunto" class="col-sm-2 col-form-label">Asunto</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="asunto" name="asunto">
		</div>
	</div>
	<div class="row mb-3">
		<label for="inicio" class="col-sm-2 col-form-label">Inicio</label>
		<div class="col-sm-10">
			<input type="datetime-local" class="form-control" id="inicio"
				name="inicio">
		</div>
	</div>
	<div class="row mb-3">
		<label for="fin" class="col-sm-2 col-form-label">Fin</label>
		<div class="col-sm-10">
			<input type="datetime-local" class="form-control" id="fin" name="fin">
		</div>
	</div>
	<div class="row mb-3">
		<label for="prioridad" class="col-sm-2 col-form-label">Prioridad</label>
		<div class="col-sm-10">
			<select class="form-select" id="prioridad" name="prioridad">
				<option>ALTA</option>
				<option>MEDIA</option>
				<option>BAJA</option>
			</select>
		</div>
	</div>
	<div class="row mb-3">
		<label for="usuario" class="col-sm-2 col-form-label">Usuario</label>
		<div class="col-sm-10">
			<select class="form-select" id="usuario" name="usuario">
				<%
				for (Usuario usuario : usuarios) {
				%>
				<option value="<%=usuario.getId()%>"><%=usuario.getNombre() %></option>
				<%
				}
				%>
			</select>
		</div>
	</div>
	<div class="row mb-3">
		<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm-10">
			<textarea rows="5" class="form-control" id="descripcion"
				name="descripcion"></textarea>
		</div>
	</div>

	<button type="submit" class="btn btn-primary">Guardar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>