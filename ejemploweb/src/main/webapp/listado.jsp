<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Class.forName("org.sqlite.JDBC");

String url = "jdbc:sqlite:monitores.sqlite";

String sql = "SELECT * FROM monitores";

Connection con = DriverManager.getConnection(url);
Statement st = con.createStatement();

String id = request.getParameter("id");
String color = request.getParameter("color");

ResultSet rs = null;

if (color != null && !color.isBlank()) {
	sql += " WHERE color LIKE '%" + color + "%'";
	rs = st.executeQuery(sql);
} else if (id != null) {
	sql = "DELETE FROM monitores WHERE id=" + id;
	
	st.executeUpdate(sql);
	
	response.sendRedirect("listado.jsp");
	
	return;
} else {
	rs = st.executeQuery(sql);
}
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
				<th>OPCIONES</th>
			</tr>
		</thead>

		<tbody>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("id")%></td>
				<td><%=rs.getString("ancho")%></td>
				<td><%=rs.getString("alto")%></td>
				<td><%=rs.getString("diagonal")%></td>
				<td><%=rs.getString("color")%></td>
				<td><a href="formulario.jsp?id=<%=rs.getString("id")%>">Editar</a>
					<a href="listado.jsp?id=<%=rs.getString("id")%>">Borrar</a></td>
			</tr>
			<%
			}

			rs.close();
			st.close();
			con.close();
			%>
		</tbody>

		<tfoot>
			<tr>
				<td colspan="5"></td>

				<td><a href="formulario.jsp">Añadir</a></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>