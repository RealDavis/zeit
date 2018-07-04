<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.zeit.utils.FormUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../commons/head.jsp"/>
<c:import url="../commons/navbar.jsp"/>

<div class="container">
	<div class="row">
		<div class="row">
			<div class="col-12">
				<section class="header">
					<h2>Cadastro de tarefas</h2>
					<p>Preencha os campos seguintes e cadastre suas tarefas</p>
				</section>
			</div>
		</div>
		<div class="col-12">
			<main class="card">
				<div class="card-body">
					<c:if test="${sessionScope.errorMessage != null}">
	        			<c:import url="../commons/msgErro.jsp"/>
		        	</c:if>
		        	
					<form method="POST" action="<c:url value="/tarefa/cadastrar"/>" id="frmTarefa">
						<div class="form-group">
							<label for="tarefa">Tarefa</label>
							<input type="text" class="form-control" id="tarefa" name="tarefa" value="${sessionScope.entidade.getTarefa()}" 
							required minlength="5" maxlength="100">
							<label for="tarefa" generated="true" class="error invalid-feedback"></label>
						</div>
						<div class="form-row">
							<div class="col">
								<div class="form-group">
									<label for="data">Data</label>
									<input type="date" class="form-control" id="data" name="data" value="${sessionScope.entidade.getData()}">
									<label for="data" generated="true" class="error invalid-feedback"></label>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="hora">Horário</label>
									<input type="time" class="form-control" id="hora" name="hora" value="${sessionScope.entidade.getHora()}">
									<label for="hora" generated="true" class="error invalid-feedback"></label>
								</div>
							</div>
						</div>
						<div class="form-group">
	    					<label for="observacoes">Observações</label>
	    					<textarea class="form-control" id="observacoes" name="observacoes" rows="3">${sessionScope.entidade.getObservacoes()}</textarea>
	  						<label for="observacoes" generated="true" class="error invalid-feedback"></label>
	  					</div>
					
						<div class="row">
							<button type="submit" class="btn btn-primary">
								Cadastrar
								<i class="fas fa-check"></i>
							</button>
							<button type="reset" class="btn btn-danger">
		                        Limpar
		                        <i class="fas fa-times-circle"></i>
		                    </button>
						</div>
					</form>
				</div>
			</main>
		</div>
	</div>
</div>

<c:remove var = "entidade"/>

<c:import url="../commons/end-body.jsp" />