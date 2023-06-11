<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dados Cadastrados</title>
</head>
<body>

<H1>Dados Cadastrados</H1>

<%-- O JSP usa o objeto impl�tico sessionScope do EL para ler os atributos colocados anteriormente na sess�o --%>
<table>
	<tr>
		<td><strong>E-mail:</strong></td>
		<td>${sessionScope.email}</td>
	</tr>
	<tr>
		<td><strong>Nome:</strong></td>
		<td>${sessionScope.nome}</td>
	</tr>
	<tr>
		<td><strong>Telefone:</strong></td>
		<td>${sessionScope.telefone}</td>
	</tr>
</table>

</body>
</html>