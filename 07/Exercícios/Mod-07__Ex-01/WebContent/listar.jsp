<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gravar Atributo</title>
</head>
<body>

<table border="1">
	<tr>
		<td><strong>Nome</strong></td>
		<td><strong>Valor</strong></td>
	</tr>
	<c:forEach var="entry" items="${atributos}">
		<tr>
			<td>${entry.key}</td>
			<td>${entry.value}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>