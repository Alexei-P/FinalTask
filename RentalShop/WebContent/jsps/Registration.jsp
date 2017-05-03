<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<fmt:setBundle basename="by.epam.web.internationalization.locale_${sessionScope.local }" var="loc"/>
<title>Registration page</title>
</head>
<body>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h1><fmt:message bundle="${loc}" key="registration.h1.welcome" /></h1>
		</div>
	</div>
	<form action="${pageContext.request.contextPath}/RentalShopController?actionPOST=Login" method="post">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="form-group">
					<label for="exampleInputEmail1"><fmt:message bundle="${loc}" key="registration.label.login" /></label> <input type="text"
						class="form-control" id="exampleInputEmail1" placeholder="Login"
						name="login">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1"><fmt:message bundle="${loc}" key="registration.label.password" /></label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password" name="password">
				</div>
				<button type="submit" class="btn btn-default" value="login"><fmt:message bundle="${loc}" key="registration.button.Login" /></button>
			</div>
		</div>
	</form>
	<div class="row">
	<div class="col-md-6 col-md-offset-3">
		<a class="btn btn-default"
			href="${pageContext.request.contextPath}/jsps/Register.jsp" role="button"><fmt:message bundle="${loc}" key="registration.button.register" /></a>
	</div>
	</div>
</body>
</html>