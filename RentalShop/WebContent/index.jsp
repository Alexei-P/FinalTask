<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<fmt:setBundle basename="by.epam.web.internationalization.locale_${sessionScope.local }" var="loc"/>
<title>Insert title here</title>

</head>
<body>
	<div class="jumbotron">
		<h1><fmt:message bundle="${loc}" key="index.h1.welcome" /></h1>
		<p><fmt:message bundle="${loc}" key="index.p.1" /></p>
	</div>
	<nav id="nav_bar">
	<ul>
		<li><a href="RentalShopController?action=Products"><fmt:message bundle="${loc}" key="index.href.products" /></a></li>
		<li><a href="RentalShopController?action=About"><fmt:message bundle="${loc}" key="index.href.about" /></a></li>
		<li><a href="RentalShopController?action=Registration"><fmt:message bundle="${loc}" key="index.href.login" /></a></li>
	</ul>
	</nav>

	<div class="container">
		<h2><fmt:message bundle="${loc}" key="index.h2.choose_lang" /></h2>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				data-toggle="dropdown">
				<fmt:message bundle="${loc}" key="index.button.choose" /><span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="RentalShopController?action=EN"><fmt:message bundle="${loc}" key="index.dropdown.en" /></a></li>
				<li><a href="RentalShopController?action=RU"><fmt:message bundle="${loc}" key="index.dropdown.ru" /></a></li>
			</ul>
		</div>
	</div>
	
</body>
</html>