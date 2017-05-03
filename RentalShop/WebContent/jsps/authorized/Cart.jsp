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

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/jsps/includes/Header.jsp" />
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h3><fmt:message bundle="${loc}" key="cart.h3.welcome1" /> "${sessionScope.User.login} " <fmt:message bundle="${loc}" key="cart.h3.welcome2" /></h3>
		</div>
	</div>
	<c:if test="${not empty sessionScope.cart.list}">
		<div class="container">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%"><fmt:message bundle="${loc}" key="cart.th.product" /></th>
						<th style="width: 10%"><fmt:message bundle="${loc}" key="cart.th.price" /></th>
						<th style="width: 8%"><fmt:message bundle="${loc}" key="cart.th.quantity" /></th>
						<th style="width: 22%" class="text-center"><fmt:message bundle="${loc}" key="cart.th.subtotal" /></th>
						<th style="width: 10%"></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${sessionScope.cart.list}" var="item">
						<tr>
							<form action="${pageContext.request.contextPath}/RentalShopController?actionPOST=UpdateCart" method="post">
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="http://placehold.it/100x100" alt="..."
											class="img-responsive" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${item.equipment.name }</h4>
									</div>
								</div>
							</td>
							<td data-th="Price" id="price">${item.equipment.price }</td>
							<td data-th="Quantity"><input type="number" min="0"
								class="form-control text-center quantity" id="quantity"
								value="${item.quantity}" name="quantity"></td>
							<td data-th="Subtotal" class="text-center" id="total">${item.equipment.price*item.quantity}</td>
							<td class="actions" data-th="">

								<button type="submit" class="btn btn-info btn-sm" id="update"
									name="update" value="${item.equipment.id}">
									<i class="fa fa-refresh"><fmt:message bundle="${loc}" key="cart.button.update" /></i>
								</button>
								</form>
								<div class="col-md-6 col-md-offset-3">
									<a class="btn btn-danger btn-sm"
										href="${pageContext.request.contextPath}/RentalShopController?action=DeleteFromCart&delete=${item.equipment.id}"
										role="button"><fmt:message bundle="${loc}" key="cart.button.delete" /></a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				</c:if>
				<tfoot>
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/RentalShopController?action=Products"
							class="btn btn-warning"><i class="fa fa-angle-left"></i>
								<fmt:message bundle="${loc}" key="cart.button.continue" /></a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>${sessionScope.cart.total}</strong></td>
						<c:if test="${not empty sessionScope.cart.list}">
						<td><a href="${pageContext.request.contextPath}/RentalShopController?action=AddCart" class="btn btn-success btn-block" ><fmt:message bundle="${loc}" key="cart.button.makeorder" /><i class="fa fa-angle-right"></i>
						</a></td>
						</c:if>
					</tr>
				</tfoot>
			</table>
		</div>
</body>
</html>