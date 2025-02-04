<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<%
@SuppressWarnings("unchecked")
ArrayList<Cita> citas = (ArrayList<Cita>) request.getAttribute("citas");
%>

	<table class="table table-bordered">
		<tbody>
			<%
			for (Cita cita : citas) {
			%>
			<tr>
				<td><a href="cita?id=<%=cita.getId()%>"> <%=cita.getAsunto()%>
				</a></td>
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
		
		<tfoot>
			<tr>
				<td>
					<a class="btn btn-primary" href="formulario">Añadir cita</a>
				</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tfoot>
	</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>