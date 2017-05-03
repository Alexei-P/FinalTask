<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<fmt:setBundle
	basename="by.epam.web.internationalization.locale_${sessionScope.local }"
	var="loc" />
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/jsps/includes/Header.jsp" />
	<h1>
		<fmt:message bundle="${loc}" key="admin.h1.welcome" />
	</h1>
	<a class="btn btn-default"
		href="${pageContext.request.contextPath}/RentalShopController?action=getAllUsers"
		role="button"><fmt:message bundle="${loc}"
			key="admin.button.getusers" /></a>
	<c:if test="${AllUsers != null}">
		<div class="container">
			<table id="users" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%"><fmt:message bundle="${loc}"
								key="admin.th.userid" /></th>
						<th style="width: 10%"><fmt:message bundle="${loc}"
								key="admin.th.login" /></th>
						<th style="width: 8%"><fmt:message bundle="${loc}"
								key="admin.th.password" /></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${AllUsers}" var="user">
						<tr>

							<td data-th="Product">
								<div class="row">
									<div class="col-sm-10">
										<h4 class="nomargin">${user.id}</h4>
									</div>
								</div>
							</td>
							<td data-th="Price" id="price">${user.login}</td>
							<td data-th="Quantity">${user.password}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<a class="btn btn-default"
		href="${pageContext.request.contextPath}/RentalShopController?action=getAllEquipmentAdmin"
		role="button">Get Equipment</a>
	<c:if test="${sessionScope.EquipmentList != null}">
		<mytag:prodList equipmentList="${sessionScope.EquipmentList}" />
	</c:if>
</body>
</html>