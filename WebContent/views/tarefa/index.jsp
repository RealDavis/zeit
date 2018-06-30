<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<c:import url="../commons/head.jsp"/>
<c:import url="../commons/navbar.jsp"/>

<div class="container">
	<div class="row">
		<div class="col-12">
			<c:if test="${sessionScope.errorMessage != null}">
        		<c:import url="../commons/msgErro.jsp"/>
        	</c:if>
			<main>
				<ul class="nav nav-tabs nav-justified" role="tablist">
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#tarefasPassadas">Tarefas passadas / concluídas</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#tarefasHoje">Tarefas de hoje / em aberto</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#tarefasFuturas">Tarefas futuras</a>
					</li>
				</ul>
			
			<c:if test="${sessionScope.successMessage != null}">
				<c:import url="../commons/msgSuccess.jsp"/>
			</c:if>
			
			  <!-- Tab panes -->
				<div class="tab-content">
					<div id="tarefasPassadas" class="container tab-pane active">
						<c:import url="tableTarefasPassadas.jsp"/>
					</div>
					<div id="tarefasHoje" class="container tab-pane fade">
						<c:import url="tableTarefasHoje.jsp"/>
					</div>
					<div id="tarefasFuturas" class="container tab-pane fade"><br>
						<c:import url="tableTarefasFuturas.jsp"/>
					</div>
				</div>
			<main>
		</div>
	</div>
</div>

<c:import url="modalExclusao.jsp"/>
 
<c:import url="../commons/end-body.jsp"/>