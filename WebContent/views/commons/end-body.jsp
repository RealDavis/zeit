<%@page import="br.com.jestoque.utils.JsUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


		<!--JavaScript at end of body for optimized loading-->
		<script type="text/javascript" src="../assets/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="../assets/js/popper.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/dist/js/bootstrap.min.js"></script>
		${jsPersonalizado}
		
		<%
			JsUtil.eraseJs(request);
		%>
	</body>
</html>