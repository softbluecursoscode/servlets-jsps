<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<H1>Procurar Alunos</H1>

<form action="ProcurarAluno.action" method="get">
<input type="hidden" name="numSala" value="${numSala}">
<table>
	<tr>
		<td align="right">Nome:</td>
		<td><input type="text" name="nome"></td>
		<td><input type="submit" value="Buscar"></td>
	</tr>
</table>
</form>

<c:if test="${alunos != null}">
	<BR>
	<table border="1" style="width: 100%">
	<c:choose>
		<c:when test="${!empty(alunos)}">
			<c:forEach var="aluno" items="${alunos}">
				<c:url var="adicionarUrl" value="AdicionarAlunoSala.action">
					<c:param name="matricula">${aluno.matricula}</c:param>
					<c:param name="numSala">${numSala}</c:param>
				</c:url>
				<tr>
					<td>${aluno.matricula} - ${aluno.nome}</td>
					<td><A href="${adicionarUrl}">Adicionar</A></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr><td>Nenhum aluno encontrado</td></tr>
		</c:otherwise>
	</c:choose>
	</table>
</c:if>
<jsp:include page="footer.jsp" />