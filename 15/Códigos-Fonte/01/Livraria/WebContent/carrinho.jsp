<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt_BR" />

<h3>CARRINHO DE COMPRAS</h3>

<c:if test="${carrinho.itens.size() == 0}">
	<br><h4>Seu carrinho está vazio</h4>
</c:if>

<c:if test="${carrinho.itens.size() > 0}">
	
	<table>
		<c:forEach var="item" items="${carrinho.itens}">
			<tr>
				<td><A href="Carrinho.action?op=remover&id=${item.id}">Remover</A></td>
				<td>${item.titulo}</td>
				<td><fmt:formatNumber value="${item.preco}" type="currency" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="right"><fmt:formatNumber value="${carrinho.valorTotal}" type="currency" /></td>
		</tr>
	</table>

	<c:if test="${usuario != null}">
		<form action="FecharPedido.action">
			<input type="submit" class="button" value="Fechar Pedido">
		</form>
	</c:if>
	<c:if test="${usuario == null}">
		<br><span class="erro">Efetue o login antes de poder fechar o pedido!</span>
	</c:if>
</c:if>

<jsp:include page="footer.jsp" />