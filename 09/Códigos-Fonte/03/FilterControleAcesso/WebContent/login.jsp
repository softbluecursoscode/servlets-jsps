<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<H1>Login</H1>

<FORM action="LoginServlet" method="POST">
<TABLE>
	<TR>
		<TD>Usuário:</TD>
		<TD><INPUT type="text" name="user"></TD>
	</TR>
	<TR>
		<TD>Senha:</TD>
		<TD><INPUT type="text" name="password"></TD>
	</TR>
	<TR>
		<TD colspan="2"><INPUT type="submit" value="OK"></TD>
	</TR>
</TABLE>
</FORM>
</body>
</html>