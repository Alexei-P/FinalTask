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
<fmt:setBundle basename="by.epam.web.internationalization.locale_${sessionScope.local }" var="loc"/>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
		<c:if test="${sessionScope.User.login eq 'admin'}">
		<li><a href="RentalShopController?action=Admin"><fmt:message bundle="${loc}" key="header.nav.admin" /></a></li>
		</c:if>
			<li><a href="RentalShopController?action=Products"><fmt:message bundle="${loc}" key="header.nav.products" /></a></li>
			<li><a href="RentalShopController?action=About"><fmt:message bundle="${loc}" key="header.nav.about" /></a></li>
			<li><a href="RentalShopController?action=Registration"><fmt:message bundle="${loc}" key="header.nav.register" /></a></li>
			<li><a href="RentalShopController?action=Welcome"><fmt:message bundle="${loc}" key="header.nav.welcome" /></a></li>
			<li><a href="RentalShopController?action=UserPage"><fmt:message bundle="${loc}" key="header.nav.userpage" /></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${sessionScope.User.login != null}">
				<li>${sessionScope.User.login} <fmt:message bundle="${loc}" key="header.nav.logged" />  </li>
				<li><a href="RentalShopController?action=SignOut"><fmt:message bundle="${loc}" key="header.nav.logout" /></a></li>
			</c:if>
			<li><a href="RentalShopController?action=Cart"><img src="imgs/cart.png" width="20"
					height="20" border="0"></a></li>
		</ul>
	</div>
	<!-- /.container-fluid --> </nav>
</body>
</html>