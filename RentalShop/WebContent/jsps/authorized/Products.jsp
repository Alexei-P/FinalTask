<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<fmt:setBundle basename="by.epam.web.internationalization.locale_${sessionScope.local }" var="loc"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/jsps/includes/Header.jsp" />
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h1><fmt:message bundle="${loc}" key="products.h1.welcome" /></h1>
		</div>
	</div>
	<c:if test="${sessionScope.EquipmentList != null}">
		<div class="col-md-6 col-md-offset-3">
			<table class="table">
				<tr>
					<th><fmt:message bundle="${loc}" key="products.th.id" /></th>
					<th><fmt:message bundle="${loc}" key="products.th.name" /></th>
					<th><fmt:message bundle="${loc}" key="products.th.price" /></th>
					<th><fmt:message bundle="${loc}" key="products.th.quantity" /></th>
				</tr>
				<c:forEach items="${sessionScope.EquipmentList}" var="equipment">
					<form action="${pageContext.request.contextPath}/RentalShopController?actionPOST=AddToCart" method="post">
						<tr>
							<td>${equipment.id }</td>
							<td>${equipment.name }</td>
							<td>${equipment.price }</td>
							<td data-th="Quantity"><input type="number" min="0" 
								class="form-control text-center" value="0" name="quantity"></td>
							<td><button type="submit" class="btn btn-success"
									name="addToCart" value="${equipment.id}"><fmt:message bundle="${loc}" key="products.button.addtocart" /></button></td>
						</tr>
					</form>
				</c:forEach>
			</table>
			<tfoot>
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/RentalShopController?action=Cart"
						class="btn btn-success btn-block"><fmt:message bundle="${loc}" key="products.button.gotocart" /> <i
							class="fa fa-angle-right"></i>
					</a></td>
				</tr>
			</tfoot>
		</div>
		<%-- <a class="btn btn-default"
			href="${pageContext.request.contextPath}/RentalShopController?action=Cart"
			role="button">Go to the Cart</a> --%>
	</c:if>

</body>
</html>