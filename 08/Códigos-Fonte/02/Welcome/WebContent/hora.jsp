<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hora</title>
</head>
<body>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String date = sdf.format(new Date());
%>

<H1><%= date %></H1>

</body>
</html>