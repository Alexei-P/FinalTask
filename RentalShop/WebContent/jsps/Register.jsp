<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/checkpassword.js"></script>
<fmt:setBundle
	basename="by.epam.web.internationalization.locale_${sessionScope.local }"
	var="loc" />
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h1>
				<fmt:message bundle="${loc}" key="register.h1.welcome" />
			</h1>
		</div>
	</div>
	<form
		action="${pageContext.request.contextPath}/RentalShopController?actionPOST=Register"
		method="post">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="form-group">
					<label for="exampleInputEmail1"><fmt:message
							bundle="${loc}" key="register.label.login" /></label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="login"
						placeholder="New Login">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1"><fmt:message
							bundle="${loc}" key="register.label.password" /></label> <input
						type="password" class="form-control" id="pas1" name="password"
						placeholder="New Password">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword2"><fmt:message
							bundle="${loc}" key="register.label.password2" /></label> <input
						type="password" class="form-control" id="pas2" name="password2"
						placeholder="Confirm Password">
				</div>
				<button type="button" id="button_submit" class="btn btn-default">
					<fmt:message bundle="${loc}" key="register.button.register" />
				</button>
			</div>
		</div>
	</form>

</body>
</html>