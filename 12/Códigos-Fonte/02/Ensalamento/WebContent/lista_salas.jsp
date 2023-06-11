<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<H1>Lista de Salas Cadastradas</H1>

<table border="1" style="width: 100%">

	<tr>
		<td align="center"><strong>Número</strong></td>
		<td align="center"><strong>Capacidade</strong></td>
		<td align="center"><strong>Turma</strong></td>
		<td></td>
	</tr>
	
	<c:forEach var="sala" items="${salas}">
		<tr>
			<td align="center">${sala.numero}</td>
			<td align="center">${sala.capacidade}</td>
			<td align="center">${sala.turma.nome}</td>
			
			<c:url var="alunosUrl" value="/ListarAlunos.action">
				<c:param name="numSala">${sala.numero}</c:param>
			</c:url>
			
			<td align="center"><a href="${alunosUrl}">Alunos</a></td>
		</tr>
	</c:forEach>
	
</table>

<jsp:include page="footer.jsp" />