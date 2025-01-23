<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Class.forName("org.sqlite.JDBC");

String url = "jdbc:sqlite:monitores.sqlite";

String sql = "SELECT * FROM monitores";

String color = request.getParameter("color");

if (color != null && !color.isBlank()) {
	sql += " WHERE color LIKE '%" + color + "%'";
}

Connection con = DriverManager.getConnection(url);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sql);
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
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>