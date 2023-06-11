<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt_BR" />

<h3>PEDIDOS</h3>

<c:if test="${usuario == null}">
	<br><h4>Efetue o login para poder consultar seus pedidos!</h4>
</c:if>

<c:if test="${usuario != null}">
	<c:if test="${pedidos.size() == 0}">
		<br><h4>Você não possui pedidos!</h4>
	</c:if>
	<c:if test="${pedidos.size() > 0}">
		<table>
			<c:forEach var="p" items="${pedidos}">
				<tr>
					<td>${p.id}</td>
					<td><fmt:formatDate value="${p.data}" pattern="dd/MM/yyyy HH:mm" /></td>
					<td>${p.status}</td>
					<td><fmt:formatNumber value="${p.valor}" type="currency" /></td>
					<td>
					<c:forEach var="l" items="${p.livros}">
						- ${l.titulo}<br>
					</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</c:if>

<jsp:include page="footer.jsp" />