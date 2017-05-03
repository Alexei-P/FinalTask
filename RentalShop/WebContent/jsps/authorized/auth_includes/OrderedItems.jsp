<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:setBundle basename="by.epam.web.internationalization.locale_${sessionScope.local }" var="loc"/>
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-6 col-md-offset-3">
		<table class="table">
			<tr>
				<th><fmt:message bundle="${loc}" key="ordereditems.th.name" /></th>
				<th><fmt:message bundle="${loc}" key="ordereditems.th.price" /></th>
				<th><fmt:message bundle="${loc}" key="ordereditems.th.quantity" /></th>
				<th><fmt:message bundle="${loc}" key="ordereditems.th.total" /></th>
			</tr>
			<c:forEach items="${requestScope.UserItems}" var="item">
				<c:if test="${item.quantity != 0}">
					<tr>
						<td>${item.equipment.name }</td>
						<td>${item.equipment.price }</td>
						<td>${item.quantity }</td>
						<td>${item.equipment.price*item.quantity}</td>
						<td>
							<div class="col-md-6 col-md-offset-3">
								<a class="btn btn-danger btn-sm"
									href="${pageContext.request.contextPath}/RentalShopController?action=DeleteFromOrders&delete=${item.id}"
									role="button">Delete</a>
							</div>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
</body>
</html>