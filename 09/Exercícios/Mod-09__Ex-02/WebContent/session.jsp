<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<h2>Insira um atributo na session:</h2>

<form action="Gravar">
<table>
	<tr>
		<td>Nome:</td>
		<td><input type="text" name="nome"></td>
	</tr>
	<tr>
		<td>Valor:</td>
		<td><input type="text" name="valor"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Gravar"></td>
	</tr>
</table>
</form>

</body>
</html>