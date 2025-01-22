<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String sNumero = request.getParameter("numero");
int numero = Integer.parseInt(sNumero);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prueba con JSP</title>
</head>
<body>
	<p><%=LocalDateTime.now()%></p>
	<p><%=sNumero%></p>

	<%
	for (int i = 1; i <= numero; i++) {

		if (i == 4) {
	%><p>Vamos por la mitad</p>
	<%
	}
	%>
	<h1>
		Hola
		<%=i%></h1>
	<%
	}
	%>
</body>
</html>