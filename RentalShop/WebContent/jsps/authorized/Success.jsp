<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:setBundle basename="by.epam.web.internationalization.locale_${sessionScope.local }" var="loc"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/jsps/includes/Header.jsp" />
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h3><fmt:message bundle="${loc}" key="success.h3.welcome1" /> "${sessionScope.User.login}" <fmt:message bundle="${loc}" key="success.h3.welcome2" /></h3>
		</div>
	</div>
</body>
</html>