<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/publica/publica-nav.jsp" />

	<div class="container">
		<div class="row">

			<div class="col">
				<h2>Usu�rios</h2>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Cpf</th>
							<th>Nascimento</th>
							<th>E-mail</th>
							<th>Ativado?</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="usuario" items="${listaUsuarios}">
							<tr>
								<td><c:out value="${usuario.id}" /></td>
								<td><c:out value="${usuario.nome}" /></td>
								<td><c:out value="${usuario.cpf}" /></td>
								<td><fmt:formatDate value='${usuario.dataNascimento}'
										type='date' pattern='dd/MM/yyyy' /></td>
								<td><c:out value="${usuario.email}" /></td>

								<td><span> <c:out
											value="${usuario.ativo=='true' ? 'ATIVO' : 'N�O ATIVO'}" />
								</span></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>