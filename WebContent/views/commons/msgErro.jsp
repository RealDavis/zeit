<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.zeit.utils.MsgUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="row">
	<div class="col-12">
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
 			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    			<span aria-hidden="true">&times;</span>
  			</button>
  			
  			<c:if test = "${sessionScope.errorMessage != null}">
        		 ${sessionScope.errorMessage}
        		 <c:remove var = "errorMessage"/>
      		</c:if>
			
			<c:remove var = "errorMessage"/>
			
		</div>
	</div>
</div>