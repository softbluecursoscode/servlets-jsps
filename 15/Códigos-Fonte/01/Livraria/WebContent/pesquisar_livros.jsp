<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt_BR" />

<h3>PESQUISA DE LIVROS</h3>
<form action="PesquisarLivros.action">
<table>
	<tr>
		<td>Título:</td>
		<td><input type="text" name="titulo" size="30" /></td>
	</tr>
	<tr>
		<td>Autor:</td>
		<td><input type="text" name="autor" size="30" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Pesquisar" class="button" /></td>
	</tr>
</table>
</form>

<c:forEach var="livro" items="${livros}">
	<span class="livro_titulo">${livro.titulo}</span><br>
	<span class="livro_autor">${livro.autor}</span><br>
	<span class="livro_info">Editora ${livro.editora}, ${livro.ano}.</span><br>
	<span class="livro_preco"><fmt:formatNumber value="${livro.preco}" type="currency" /></span><br>
	<A href="Carrinho.action?op=inserir&id=${livro.id}">Adicionar este item ao carrinho</A><br><br>
</c:forEach>

<jsp:include page="footer.jsp" />