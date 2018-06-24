<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<c:import url="../commons/head.jsp"/>

<div class="container">
	<div class="row">
		<div class="col-12">
			<main>
				<ul class="nav nav-tabs nav-fill">
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#tarefasPassadas">Tarefas passadas / concluidas</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#tarefasHoje">Tarefas para hoje</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#tarefasFuturas">Tarefas futuras</a>
					</li>
				</ul>
			</main>
		</div>
	</div>
</div>

<div class="tab-content">
	<div class="tab-pane container fade" id="tarefasPassadas">
		<c:import url="tableTarefasPassadas.jsp"/>
	</div>
	<div class="tab-pane container fade" id="tarefasHoje">
		<c:import url="tableTarefasHoje.jsp"/>
	</div>
	<div class="tab-pane container fade" id="tarefasFuturas">
		<c:import url="tableTarefasFuturas.jsp"/>
	</div>
</div>

<c:import url="../commons/end-body.jsp"/>