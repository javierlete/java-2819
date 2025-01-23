<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Class.forName("org.sqlite.JDBC");
String url = "jdbc:sqlite:monitores.sqlite";

String id = request.getParameter("id");

Connection con = null;
Statement st = null;
ResultSet rs = null;

if (request.getMethod().equals("GET")) {

	if (id != null) {
		String sql = "SELECT * FROM monitores WHERE id=" + id;

		con = DriverManager.getConnection(url);
		st = con.createStatement();
		rs = st.executeQuery(sql);

		rs.next();
	}
} else {
	String ancho = request.getParameter("ancho");
	String alto = request.getParameter("alto");
	String diagonal = request.getParameter("diagonal");
	String color = request.getParameter("color");

	String plantilla;
	String sql;
	
	if (id.isBlank()) {
		plantilla = "INSERT INTO monitores (ancho, alto, diagonal, color) VALUES (%s, %s, %s, '%s')";

		sql = String.format(plantilla, ancho, alto, diagonal, color);
	} else {
		plantilla = "UPDATE monitores SET ancho=%s, alto=%s, diagonal=%s, color='%s' WHERE id=%s";

		sql = String.format(plantilla, ancho, alto, diagonal, color, id);
	}

	con = DriverManager.getConnection(url);
	st = con.createStatement();
	st.executeUpdate(sql);

	response.sendRedirect("listado.jsp");
	
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>

<link rel="stylesheet" href="css/listado.css">

</head>
<body>

	<h1>Formulario</h1>

	<form method="post">
		<input type="hidden" name="id" value="<%=rs == null ? "" : rs.getString("id")%>">
		<div>
			<label for="ancho">Ancho</label> <input name="ancho" id="ancho"
				value="<%=rs == null ? "" : rs.getString("ancho")%>">
		</div>
		<div>
			<label for="alto">Alto</label> <input name="alto" id="alto"
				value="<%=rs == null ? "" : rs.getString("alto")%>">
		</div>
		<div>
			<label for="diagonal">Pulgadas</label> <input name="diagonal"
				id="diagonal"
				value="<%=rs == null ? "" : rs.getString("diagonal")%>">
		</div>
		<div>
			<label for="color">Color</label> <input name="color" id="color"
				value="<%=rs == null ? "" : rs.getString("color")%>">
		</div>
		<div>
			<button>Guardar</button>
		</div>
	</form>
	<%
	if (rs != null) {
		rs.close();
		st.close();
		con.close();
	}
	%>
</body>
</html>