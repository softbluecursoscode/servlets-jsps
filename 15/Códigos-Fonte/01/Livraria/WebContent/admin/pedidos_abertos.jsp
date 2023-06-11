<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="livraria.service.PedidoService"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt_BR" />

<h3>GERENCIAR PEDIDOS</h3>

<c:if test="${pedidos.size() == 0}">
	<br><h4>Não existem pedidos para processar.</h4>
</c:if>
<c:if test="${pedidos.size() > 0}">
<form action="ProcessarPedidos.action" method="post">
<table>
	<c:forEach var="p" items="${pedidos}">
		<tr>
			<td>${p.id}</td>
			<td>${p.usuario.nome}</td>
			<td><fmt:formatNumber value="${p.valor}" type="currency" /></td>
			<td>
				<select name="status_${p.id}">
					<option value="">Não processar</option>				
					<option value="<%= PedidoService.STATUS_APROVADO %>"><%= PedidoService.STATUS_DESC_APROVADO %></option>
					<option value="<%= PedidoService.STATUS_CANCELADO %>"><%= PedidoService.STATUS_DESC_CANCELADO %></option>
				</select>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4"><input type="submit" class="button" value="Processar Pedidos"></td>
	</tr>
</table>
</form>
</c:if>

<jsp:include page="footer.jsp" />