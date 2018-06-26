<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.zeit.utils.JsUtil"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


		<!--JavaScript at end of body for optimized loading-->
		<script type="text/javascript" src="<c:url value="/assets/js/jquery-3.2.1.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/js/popper.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/bootstrap/dist/js/bootstrap.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/bootstrap/js/src/util.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/bootstrap/js/src/tab.js"/>"></script>
		<c:if test="${jsPersonalizado != null}">
			${jsPersonalizado}
			<c:remove var = "jsPersonalizado"/>
		</c:if>
		
	</body>
</html>