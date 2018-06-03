<%@page import="org.apache.jasper.tagplugins.jstl.core.Remove"%>
<%@page import="br.com.zeit.utils.ErrorsUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="../commons/head.jsp"/>
    
    <div class="container">
        <div class="row">
	        <div class="col-12">
	        	<main>
	        	<%
	        		if(ErrorsUtil.isErro(request)) {
	        	%>
	        		<jsp:include page="../commons/msgErro.jsp"/>
	        	<%
	        		}
	        	%>
	                <form method="POST" action="cadastrar">
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
							<label for="email">Email address</label>
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
		ErrorsUtil.removeObjData(request);
	%>


    
    <jsp:include page="../commons/end-body.jsp"/>