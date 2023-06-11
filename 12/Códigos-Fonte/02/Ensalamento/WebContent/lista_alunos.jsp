<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<H1>Lista de Alunos da Sala ${sala.numero}</H1>
<H2>Capacidade: ${sala.capacidade}</H2>
<H2>Alunos na Sala: ${numAlunos}</H2>

<table border="1" style="width: 100%">

	<c:url var="ordemMatriculaUrl" value="ListarAlunos.action">
		<c:param name="numSala">${sala.numero}</c:param>
		<c:param name="ordem">MATRICULA</c:param>
	</c:url>
	<c:url var="ordemNomeUrl" value="ListarAlunos.action">
		<c:param name="numSala">${sala.numero}</c:param>
		<c:param name="ordem">NOME</c:param>
	</c:url>

	<tr>
		<td align="center"><a href="${ordemMatriculaUrl}"><strong>Matrícula</strong></a></td>
		<td align="center"><a href="${ordemNomeUrl}"><strong>Nome</strong></a></td>
		<td></td>
	</tr>
	<c:choose>
		<c:when test="${!empty(alunos)}">
			<c:forEach var="aluno" items="${alunos}">
				<tr>
					<td align="center">${aluno.matricula}</td>
					<td align="center">${aluno.nome}</td>
					
					<c:url var="excluirUrl" value="/ExcluirAlunoSala.action">
						<c:param name="matricula">${aluno.matricula}</c:param>
					</c:url>
					
					<td align="center"><a href="${excluirUrl}">Excluir</a></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr><td align="center" colspan="3">Nenhum aluno encontrado na sala</td></tr>
		</c:otherwise>
	</c:choose>
</table>
<BR>

<c:if test="${numAlunos < sala.capacidade}">
	<c:url var="procurarUrl" value="ProcurarAluno.action">
		<c:param name="numSala">${sala.numero}</c:param>
	</c:url>
	
	<A href="${procurarUrl}">Adicionar alunos à sala</A>
</c:if>

<jsp:include page="footer.jsp" />