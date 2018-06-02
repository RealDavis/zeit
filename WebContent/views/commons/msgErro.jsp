<%@page import="br.com.jestoque.utils.ErrorsUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="row">
	<div class="col-12">
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
 			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    			<span aria-hidden="true">&times;</span>
  			</button>
 			${session.getAttribute("msgErro")}
			<%
				ErrorsUtils.removeMsgErro(request);
			%>
		</div>
	</div>
</div>