<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>LOGIN</h3>

<c:if test="${usuario != null}">
	<br>
	<h4>Você já está logado,  ${usuario.nome}!</h4>
	<br>
	<A href="Logout.action">Clique aqui para deslogar</A>
</c:if>

<c:if test="${usuario == null}">
	<c:if test="${erro != null}">
		<span class="erro">${erro}</span><br>
	</c:if>
	
	<form action="Login.action" method="post">
	<table>
		<tr>
			<td>E-mail:</td>
			<td><input type="text" name="email" size="30" value="${email}" /></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password" name="senha" size="30" value="${senha}" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Login" class="button" /></td>
		</tr>
	</table>
	</form>
	
	<A href="CadastrarUsuario.action">Não possuo cadastro</A>
</c:if>

<jsp:include page="footer.jsp" />