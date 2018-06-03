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
	                    <div class="form-group">
	                        <label for="nome">Nome de usuário</label>
	                        <input type="text" class="form-control" id="nome" name="nome">
	                    </div>
	                    <div class="form-group">
	                        <label for="email">Email address</label>
	                        <input type="email" class="form-control" id="email" name="email">
	                    </div>
	                    <div class="form-group">
	                        <label for="senha">Senha</label>
	                        <input type="text" class="form-control" id="senha" name="senha">
	                    </div>
	                    <div class="form-group">
	                        <label for="senhaConfirmar">Repita a senha</label>
	                        <input type="text" class="form-control" id="senhaConfirmar" name="senhaConfirmar">
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




    
    <jsp:include page="../commons/end-body.jsp"/>