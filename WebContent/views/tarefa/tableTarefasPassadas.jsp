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
		SELECT * FROM tarefas WHERE id_usuario = ${sessionScope.idUsuario} AND data_tarefa < CURRENT_DATE();
	</sql:query>
	
	<c:choose>
		<c:when test="${fn:length(resultadoTarefas.rows) > 0}">
			<c:forEach var="listaTarefas" items="${resultadoTarefas.rows}">
				<c:out value="${listaTarefas.tarefa}"/>
				<br>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:import url="noData.jsp"/>
		</c:otherwise>
	</c:choose>