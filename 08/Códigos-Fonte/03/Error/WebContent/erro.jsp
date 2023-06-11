<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro desconhecido</title>
</head>
<body>

<H1>Erro interno da aplicação</H1>

<H2>Mensagem: <%= exception.getMessage() %></H2>
<BR>

<%
	StringWriter sw = new StringWriter();
	exception.printStackTrace(new PrintWriter(sw));
%>

<%= sw %>

</body>
</html>