<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.zeit.utils.FormUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../commons/head.jsp"/>

<div class="container">
	<div class="row">
		<div class="col-12">
			<main>
				
				<c:if test="${sessionScope.errorMessage != null}">
	        		<c:import url="../commons/msgErro.jsp"/>
	        	</c:if>
	        	<c:if test="${sessionScope.successMessage != null}">
	        		<c:import url="../commons/msgSuccess.jsp"/>
	        	</c:if>

				<form method="POST" action="cadastrar">
					<div class="form-group">
						<label for="tarefa">Tarefa</label>
						<input type="text" class="form-control" id="tarefa" name="tarefa" value="${sessionScope.entidade.getTarefa()}">
					</div>
					<div class="form-group">
						<label for="data">Data</label>
						<input type="date" class="form-control" id="data" name="data" value="${sessionScope.entidade.getData()}">
					</div>
					<div class="form-group">
						<label for="hora">Horário</label>
						<input type="time" class="form-control" id="hora" name="hora" value="${sessionScope.entidade.getHora()}">
					</div>
					<div class="form-group">
    					<label for="observacoes">Observações</label>
    					<textarea class="form-control" id="observacoes" name="observacoes" value="${sessionScope.entidade.getObservacoes()}" rows="3"></textarea>
  					</div>
				
					<div class="row">
						<button type="submit" class="btn btn-primary">
							Cadastrar
							<i class="fas fa-sign-in-alt"></i>
						</button>
						<button type="reset" class="btn btn-danger">
	                        Limpar
	                        <i class="fas fa-times-circle"></i>
	                    </button>
					</div>
				</form>
			</main>
		</div>
	</div>
</div>

	<%
		FormUtil.removeObjData(request);
	%>

<c:import url="../commons/end-body.jsp" />