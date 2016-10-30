<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../../bookstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="../../bookstrap/js/bootstrap.min.js"></script>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Danh Sach Khach Hang</h1>
		</div>
		<div class="row">
			<span style="margin-left: 900px">Welcome to :<span
				style="color: red">${username}</span><span style="margin-left: 70px"><a
					class="btn btn-danger"
					href="<c:url value="/j_spring_security_logout" />">Logout</a></span></span>
		</div>
		<div class="row">
			<p>
				<a class="btn btn-success" href="category.html">Manager Category</a>
			</p>
		</div>
		
		<div class="row" style="margin-top: 10px">
			<table>
				<thead>
					<th></th>
					<th>orderID</th>
					<th>orderCode</th>
					<th>orderDate</th>
					<th>shippingCost</th>
					<th>contactName</th>
					<th>contactPhone</th>
					<th>contactEmail</th>
					<th>description</th>
					<th></th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orderProduct }">
						<tr>
							<td>${order.orderId }</td>
							<td>${order.orderCode }</td>
							<td>${order.orderDate}</td>
							<td>${order.shippingCost}</td>
							<td>${order.contactName }</td>
							<td>${order.contactPhone}</td>
							<td>${order.contactEmail}</td>
							<td>${order.description}</td>
							<td><a
								href='<c:url value="/website/deleteproduct.html"><c:param name="productId" value="${product.productId}"/><c:param name="idPage" value="${idpage }"/></c:url>'
								class="btn btn-danger">Delete</a></td>
							<td><a class="btn btn-success" href='<c:url value="/website/orderdetails.html"><c:param name="orderId" value="${order.orderId}"/></c:url>'>Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row" style="margin-left: 150px">
			<a href='<c:url value="1.html"><c:param name="select" value=""/></c:url>'>1</a> <a href='<c:url value="2.html"><c:param name="select" value=""/></c:url>'>2</a> <a href='<c:url value="3.html"><c:param name="select" value=""/></c:url>'>3</a> <a href='<c:url value="4.html"><c:param name="select" value=""/></c:url>'>4</a> <a href='<c:url value="5.html"><c:param name="select" value=""/></c:url>'>5</a> <a href='<c:url value="6.html"><c:param name="select" value=""/></c:url>'>6</a> <a href='<c:url value="7.html"><c:param name="select" value=""/></c:url>'>7</a> <a href='<c:url value="8.html"><c:param name="select" value=""/></c:url>'>8</a> <a href='<c:url value="9.html"><c:param name="select" value=""/></c:url>'>9</a> <a href='<c:url value="10.html"><c:param name="select" value=""/></c:url>'>10</a>
		</div>
		<div class="row">
			<a class="btn btn-primary" href="<%=request.getContextPath()%>/website/index.html">Home</a>
		</div>
	</div>
	<!-- JavaScripts placed at the end of the document so the pages load faster --> 
<script src="../../assets/js/jquery-1.11.1.min.js"></script> 
<script src="../../assets/js/bootstrap.min.js"></script> 
<script src="../../assets/js/bootstrap-hover-dropdown.min.js"></script> 
<script src="../../assets/js/owl.carousel.min.js"></script> 
<script src="../../assets/js/echo.min.js"></script> 
<script src="../../assets/js/jquery.easing-1.3.min.js"></script> 
<script src="../../assets/js/bootstrap-slider.min.js"></script> 
<script src="../../assets/js/jquery.rateit.min.js"></script> 
<script src="../../assets/js/bootstrap-select.min.js"></script> 
<script src="../../assets/js/wow.min.js"></script> 
<script src="../../assets/js/scripts.js"></script>
</body>
</html>