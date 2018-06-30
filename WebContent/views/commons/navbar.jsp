<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<nav class="navbar navbar-expand-sm navbar navbar-dark bg-info">
	<a class="navbar-brand" href='<c:url value="/"/>'>Zeit</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse justify-content-end" id="navbar">
		<ul class="navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href='<c:url value="/"/>'>Lista de tarefas</a>
			</li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href='<c:url value="/tarefa/cadastro"/>'>Cadastrar tarefa</a>
			</li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href="#">Sair</a>
			</li>
		</ul>
	</div>
</nav>