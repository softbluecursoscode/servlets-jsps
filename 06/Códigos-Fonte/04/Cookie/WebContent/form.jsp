<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário</title>
</head>
<body>

<%
	Cookie[] cookies = request.getCookies();
	String nome = "";
	
	if (cookies != null) {
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("nomeusu")) {
				nome = cookie.getValue();
				break;
			}
		}
	}
%>

<form action="Salvar" method="get">

Nome do usuário: <INPUT type="text" name="nome" value="<%= nome %>"><BR>
<INPUT type="submit" value="Processar">
</form>

</body>
</html>