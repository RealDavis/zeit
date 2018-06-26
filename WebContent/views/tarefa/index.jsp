<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<c:import url="../commons/head.jsp"/>
<c:import url="../commons/navbar.jsp"/>

<div class="container">
	<div class="row">
		<div class="col-12">
			<main>
				<ul class="nav nav-tabs nav-fill"  role="tablist">
					<li class="nav-item">
						<a class="nav-link active" data-toggle="tab"  role="tab" aria-controls="tarefasPassadas" href="#tarefasPassadas" aria-selected="true">
							Tarefas passadas / concluidas
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" role="tab"  aria-controls="tarefasHoje" href="#tarefasHoje" aria-selected="false">
							Tarefas para hoje
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" role="tab" aria-controls="tarefasFuturas" href="#tarefasFuturas" aria-selected="false">
							Tarefas futuras
						</a>
					</li>
				</ul>
			</main>
		</div>
	</div>
</div>

	<c:if test="${sessionScope.successMessage != null}">
   		<c:import url="../commons/msgSuccess.jsp"/>
   	</c:if>

<div class="tab-content">
	<div class="tab-pane container fade show" id="tarefasPassadas" role="tabpanel" aria-labelledby="tarefasPassadas-tab">
		<h1>Teste</h1>
		<!-- <c:import url="tableTarefasPassadas.jsp"/> -->
	</div>
	<div class="tab-pane container fade show" id="tarefasHoje" role="tabpanel"  aria-labelledby="tarefasHoje-tab">
		b
		<!--<c:import url="tableTarefasHoje.jsp"/>-->
		<c:import url="tableTarefasHoje.jsp"/>
	</div>
	<div class="tab-pane container fade show" id="tarefasFuturas" role="tabpanel"  aria-labelledby="tarefasFuturas-tab">
		c
		<!--<c:import url="tableTarefasFuturas.jsp"/>-->
	</div>
</div>

<c:import url="../commons/end-body.jsp"/>