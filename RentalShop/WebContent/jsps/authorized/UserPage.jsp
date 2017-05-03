<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<fmt:setBundle basename="by.epam.web.internationalization.locale_${sessionScope.local }" var="loc"/>
<title>Welcome!</title>
</head>
<body>
<jsp:include page="/jsps/includes/Header.jsp" />
<div class="row">
  <div class="col-md-6 col-md-offset-3">
	<div class="starter-template">
	<h3><fmt:message bundle="${loc}" key="userpage.h3.welcome1" /> ${sessionScope.User.login}, <fmt:message bundle="${loc}" key="userpage.h3.welcome2" /></h3>
	</div>
	<div class="row">
        <div class="col-md-4">
          <h2><fmt:message bundle="${loc}" key="userpage.h2.products" /></h2>
          <p><fmt:message bundle="${loc}" key="userpage.p.gotoproducts" /></p>
          <p><a class="btn btn-default" href="RentalShopController?action=Products" role="button"><fmt:message bundle="${loc}" key="userpage.button.products" /></a></p>
        </div>
        <div class="col-md-4">
          <h2><fmt:message bundle="${loc}" key="userpage.h2.cart" /></h2>
          <p><fmt:message bundle="${loc}" key="userpage.p.gotocart" /></p>
          <p><a class="btn btn-default" href="RentalShopController?action=Cart" role="button"><fmt:message bundle="${loc}" key="userpage.button.cart" /></a></p>
        </div>
      </div>
      </div>
      </div>
	<jsp:include page="/jsps/authorized/auth_includes/OrderedItems.jsp" />
</body>
</html>