<%@page import="br.com.zeit.utils.MsgUtil"%>
<%@page import="br.com.zeit.utils.FormUtil"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
		        	
	                <form method="POST" action="<c:url value="/usuario/cadastrar"/>">
						<!--nome de usuário-->
	                    <div class="form-group">
							<label for="nome">Nome de usuário</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">
										<i class="fas fa-user-circle"></i>
									</span>
								</div>
								<input type="text" class="form-control" id="nome" name="nome" value="${sessionScope.entidade.getNome()}">
							</div>
						</div>
						<!--email-->
	                    <div class="form-group">
							<label for="email">Email</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">
										<i class="fas fa-at"></i>
									</span>
								</div>
								<input type="email" class="form-control" id="email" name="email" value="${sessionScope.entidade.getEmail()}">
							</div>
						</div>
						<!--senha-->
	                    <div class="form-group">
							<label for="senha">Senha</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">
										<i class="far fa-eye-slash"></i>
									</span>
								</div>
								<input type="password" class="form-control" id="senha" name="senha">
							</div>
						</div>
						<!--repetição de senha-->
	                    <div class="form-group">
							<label for="senhaConfirmar">Repita a senha</label>
							<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">
											<i class="far fa-eye-slash"></i>
										</span>
									</div>
									<input type="password" class="form-control" id="senhaConfirmar" name="senhaConfirmar">
								</div>
	                    </div>
	
	                    <div class="row">
	                        <button type="submit" class="btn btn-primary">
	                            Cadastrar
	                            <i class="fas fa-check-circle"></i>
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


    <c:import url="../commons/end-body.jsp"/>
    