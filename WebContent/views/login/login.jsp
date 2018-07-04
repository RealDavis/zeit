<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../commons/head.jsp"/>

<div class="container bg-danger">
	<div class="row ">
		<div class="col-xl-4 col-lg-5 col-md-6 d-none d-md-block mr-auto"><!-- banner -->
			<section class="card">
				<article class="card-body">
					<h1>Bem vindo ao Zeit</h1>
					<p>Com o Zeit, você pode:</p>
					<ul>
						<li>Salvar todos os seus compromissos</li>
						<li>salvar todos as suas tarefas</li>
						<li>Organizar sua agenda</li>
						<li>Manter-se sempre em dia com os afazeres</li>
					</ul>
					<p>Crie sua conta ou faça login e comece a aproveitar todas essas vantagens</p>
				</article>
			</section>
		</div><!-- /banner -->

	
		<div class="col-12 col-xl-4 col-lg-5 col-md-6 ml-auto"><!-- formulario login -->
			<main class="card">
				<div class="card-body">
					<h1 class="text-center">Login</h1>
				
					<c:if test="${sessionScope.errorMessage != null}">
	        			<c:import url="../commons/msgErro.jsp"/>
	        		</c:if>
				
					<form method="POST" action="<c:url value="/logar"/>" id="frmLogin">
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
							
						<div class="row">
							<button type="submit" class="btn btn-primary">
								Entrar
								<i class="fas fa-sign-in-alt"></i>
							</button>
						</div>
					</form>	
					<div class="row">
						Ainda não tem uma conta? <a href='<c:url value="/usuario/cadastro"/>'>Criar conta</a>
					</div>
				</div><!-- card -->
			</main>
		</div><!-- /formulario login -->
		
	</div><!-- row -->
</div><!-- container -->	
		
<c:import url="../commons/end-body.jsp" />