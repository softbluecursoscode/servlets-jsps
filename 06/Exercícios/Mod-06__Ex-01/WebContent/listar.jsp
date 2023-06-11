<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gravar Atributo</title>
</head>
<body>

<%
	//lê os atributos colocados pelo servlet na request
	@SuppressWarnings("unchecked")
	Map<String, Object> atributos = (Map<String, Object>) request.getAttribute("atributos");
%>

<table border="1">
	<tr>
		<td><strong>Nome</strong></td>
		<td><strong>Valor</strong></td>
	</tr>
	<% for (Map.Entry<String, Object> entry : atributos.entrySet()) { %>
		<tr>
			<td><%=entry.getKey()%></td>
			<td><%=entry.getValue()%></td>
		</tr>
	<% } %>
</table>

</body>
</html>