<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix ="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	 <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" 
	 	url="jdbc:mysql://localhost:3306/zeit"
		user="root" password="root" scope="request"/>
		
	<sql:query var="resultadoTarefas" dataSource="${ds}">
		SELECT * FROM tarefas WHERE id_usuario = ${sessionScope.idUsuario} 
		AND data_tarefa < CURRENT_DATE() OR is_concluido = TRUE ORDER BY data_tarefa DESC;
	</sql:query>
	
	<c:choose>
		<c:when test="${fn:length(resultadoTarefas.rows) > 0}">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Tarefa</th>
						<th scope="col">Data</th>
						<th scope="col">Hora</th>
						<th scope="col">Status</th>
						<th scope="col">Ações<th>
					</tr>
				</thead>
				<tbody>
			<c:forEach var="listaTarefas" items="${resultadoTarefas.rows}">
				<tr>
				    <td><c:out value="${listaTarefas.tarefa}"/></td>
				    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${listaTarefas.data_tarefa}"/></td>
				    <td><fmt:formatDate pattern="HH:mm" value="${listaTarefas.hora}"/></td>
				    <!--  <td><c:out value="${listaTarefas.observacoes}"/></td>-->
				    <td>
				    	<c:choose>
				    		<c:when test="${listaTarefas.is_concluido == true}">
				    			<c:out value="Concluido"/>
				    		</c:when>
				    		<c:otherwise>
				    			<c:out value="Em aberto"/>
				    		</c:otherwise>
				    	</c:choose>
				    </td>
				    <td>
				    	<c:choose>
				    		<c:when test="${listaTarefas.is_concluido == false}">
				    			<a class="btn btn-success btn-sm" href="<c:url value="/tarefas/concluir/${listaTarefas.id_tarefa}"/>">
			    					<i class="fas fa-check"></i>
			    				</a>
				    		</c:when>
				    		<c:otherwise>
				    			<a class="btn btn-success btn-sm disabled" href="">
			    					<i class="fas fa-check"></i>
			    				</a>
				    		</c:otherwise>
				    	</c:choose>
				    	<a class="btn btn-danger btn-sm" href="<c:url value="/tarefas/excluir/${listaTarefas.id_tarefa}"/>">
				    		<i class="fas fa-times"></i>
				    	</a>
				    </td>
				    <c:if test="${!listaTarefas.observacoes.isEmpty()}">
					    <tr>
					    	<td colspan="5">
					    		<span>Observações: </span>
					    		<c:out value="${listaTarefas.observacoes}"/>
					    	</td>
					    <tr>
				    </c:if>
				</c:forEach>
			    </tr>
			    
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<c:import url="noData.jsp"/>
		</c:otherwise>
	</c:choose>