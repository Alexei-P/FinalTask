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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/jsps/includes/Header.jsp" />
<p><fmt:message bundle="${loc}" key="about.p.welcome" /></p>
</body>
</html>