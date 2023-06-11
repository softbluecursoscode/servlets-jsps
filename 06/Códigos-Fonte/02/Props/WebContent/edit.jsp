<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar</title>
</head>
<body>

<%
	String key = (String) request.getAttribute("key");
	if (key == null) {
		key = "";
	}
	
	String value = (String) request.getAttribute("value");
	if (value == null) {
		value = "";
	}
%>

<CENTER><H1>Editar</H1></CENTER>

<form action="Save" method="post">
<table>
<tr>
	<td>Chave:</td>
	<td><input type="text" name="key" value="<%=key%>"></td>
</tr>
<tr>
	<td>Valor:</td>
	<td><input type="text" name="value" value="<%=value%>"></td>
</tr>
<tr>
	<td colspan="2" align="right"><input type="submit" value="Salvar"></td>
</tr>
</table>
</form>
</body>
</html>