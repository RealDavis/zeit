<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="row">
	<div class="col-12">
		<div class="alert alert-warning text-center" role="alert">
  			Nenhuma tarefa encontrada
		</div>	
	</div>
</div>

<div class="row">
	<div class="col-12 text-center">
		<a class="btn btn-success mx-auto" href='<c:url value="/tarefa/cadastro"/>'>
			Cadastrar tarefa
		</a>
	</div>
</div>