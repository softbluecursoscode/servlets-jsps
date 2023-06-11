<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>LIVRO</h3>

<c:if test="${erros != null}">
	<c:forEach var="erro" items="${erros}">
		<span class="erro">${erro}</span><br>
	</c:forEach>
</c:if>
	
<form action="SalvarLivro.action" method="post">
<input type="hidden" name="id" value="${id}">
<table>
	<tr>
		<td>Título:</td>
		<td><input type="text" name="titulo" size="30" value="${titulo}" /></td>
	</tr>
	<tr>
		<td>Autor:</td>
		<td><input type="text" name="autor" size="30" value="${autor}" /></td>
	</tr>
	<tr>
		<td>Editora:</td>
		<td><input type="text" name="editora" size="30" value="${editora}" /></td>
	</tr>
	<tr>
		<td>Ano:</td>
		<td><input type="text" name="ano" size="30" value="${ano}" /></td>
	</tr>
	<tr>
		<td>Preço:</td>
		<td><input type="text" name="preco" size="30" value="${preco}" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Salvar" class="button" /></td>
	</tr>
</table>
</form>

<jsp:include page="footer.jsp" />