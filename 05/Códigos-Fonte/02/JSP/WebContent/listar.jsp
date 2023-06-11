<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem do arquivo props.txt</title>
</head>
<body>

<%! 
	Properties props = new Properties();
%>

<%
	InputStream is = application.getResourceAsStream("/WEB-INF/props.txt");
	props.load(is);
	is.close();
	
	Set<Object> keys = props.keySet();
%>

<TABLE border="1" width="100%">
	<TR>
		<TD><STRONG>Nome</STRONG></TD>
		<TD><STRONG>Valor</STRONG></TD>
	</TR>
	<% for (Object k : keys) { %>
	<TR>
		<TD><%=k %></TD>
		<TD><%=props.getProperty((String) k) %></TD>
	</TR>
	<% } %>
</TABLE>

</body>
</html>