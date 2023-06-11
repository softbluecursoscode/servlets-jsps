<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>CADASTRAR USUÁRIO</h3>

<c:if test="${erros != null}">
	<c:forEach var="erro" items="${erros}">
		<span class="erro">${erro}</span><br>
	</c:forEach>
</c:if>

<form action="CadastrarUsuario.action">
<table>
	<tr>
		<td>Nome:</td>
		<td><input type="text" name="nome" size="30" value="${nome}" /></td>
	</tr>
	<tr>
		<td>E-mail:</td>
		<td><input type="text" name="email" size="30" value="${email}" /></td>
	</tr>
	<tr>
		<td>Senha:</td>
		<td><input type="password" name="senha1" size="30" value="${senha1}" /></td>
	</tr>
	<tr>
		<td>Confirmação de Senha:</td>
		<td><input type="password" name="senha2" size="30" value="${senha2}" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Cadastrar" class="button" /></td>
	</tr>
</table>
</form>

<jsp:include page="footer.jsp" />