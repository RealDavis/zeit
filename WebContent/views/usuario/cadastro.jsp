<%@page import="br.com.zeit.utils.MsgUtil"%>
<%@page import="br.com.zeit.utils.FormUtil"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:import url="../commons/head.jsp"/>
    
    <div class="container">
        <div class="row justify-content-center">
	        <div class="col-12 col-lg-8">
	        	<main class="card">
	        		<div class="card-body">
	        			<h3 class="text-center">
	        			Preencha todo o formulário para efetuar o cadastro
	        			</h3>
	        		
		        		<c:if test="${sessionScope.errorMessage != null}">
			        		<c:import url="../commons/msgErro.jsp"/>
			        	</c:if>
			        	
		                <form method="POST" action="<c:url value="/usuario/cadastrar"/>" id="frmCadastroUsuario">
							<!--nome de usuário-->
		                    <div class="form-group">
								<label for="nome">Nome de usuário</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">
											<i class="fas fa-user-circle"></i>
										</span>
									</div>
									<input type="text" class="form-control" id="nome" name="nome" value="${sessionScope.entidade.getNome()}" 
									required minlength="3" maxlength="128">
									<label for="nome" generated="true" class="error invalid-feedback"></label> 
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
									<input type="email" class="form-control" id="email" name="email" value="${sessionScope.entidade.getEmail()}" required>
									<label for="email" generated="true" class="error invalid-feedback"></label> 
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
									<input type="password" class="form-control" id="senha" name="senha" required minlength="8" maxlength="200">
									<label for="senha" generated="true" class="error invalid-feedback"></label> 
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
										<input type="password" class="form-control" id="senhaConfirmar" name="senhaConfirmar" required minlength="8" maxlength="200">
										<label for="senhaConfirmar" generated="true" class="error invalid-feedback"></label> 
									</div>
		                    </div>
		
		                    <div class="row justify-content-start">
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
	        		</div>
            	</main>
	        </div>
        </div>
    </div>

	<c:remove var="entidade"/>

    <c:import url="../commons/end-body.jsp"/>