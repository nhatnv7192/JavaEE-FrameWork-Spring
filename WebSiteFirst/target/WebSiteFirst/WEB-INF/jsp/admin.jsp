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
			<h1>Hello Admin</h1>
		</div>
		<div>
			${message}
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
				<a class="btn btn-success" href="selectorder.html">Order</a>
			</p>
		</div>
		<div class="row">
			<div style="margin-left: 800px">
				<div class="lbl-cnt"> <span class="lbl">Show</span>
                  <div class="fld inline">
                    <div class="dropdown dropdown-small dropdown-med dropdown-white inline">
                      <button data-toggle="dropdown" type="button" class="btn dropdown-toggle"> <span class="caret"></span> </button>
                      <ul role="menu" class="dropdown-menu">
                      	<li role="presentation"><a href='<c:url value="1.html"><c:param name="select" value=""/></c:url>'>All Product</a></li>
                        <li role="presentation"><a href='<c:url value="1.html"><c:param name="select" value="hot deal"/></c:url>'>Hot Deal Product</a></li>
                        <li role="presentation"><a href='<c:url value="1.html"><c:param name="select" value="special offer"/></c:url>'>Special Offer Product</a></li>
                        <li role="presentation"><a href='<c:url value="1.html"><c:param name="select" value="new"/></c:url>'>New Product</a></li>
                        <li role="presentation"><a href='<c:url value="1.html"><c:param name="select" value="feature"/></c:url>'>Feature Product</a></li>
                        <li role="presentation"><a href='<c:url value="1.html"><c:param name="select" value="arrivals"/></c:url>'>Arrivals Product</a></li>
                      </ul>
                    </div>
                  </div>
                  <!-- /.fld --> 
                </div>
			</div>
		</div>
		<div class="row">
			<div>
			<a href="<%=request.getContextPath()%>/website/createproductget.html">Create
				new Record</a>
			</div>
		</div>
		<div class="row" style="margin-top: 10px">
			<table>
				<thead>
					<th></th>
					<th>idProduct</th>
					<th>categoryId</th>
					<th>name</th>
					<th>price</th>
					<th>discount</th>
					<th>status</th>
					<th>imageUrl</th>
					<th>description</th>
					<th></th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach var="product" items="${listProduct }">
						<tr>
							<td><img src="../${product.imageUrl }" weight="80px"
								height="40px"></td>
							<td>${product.productId }</td>
							<td>${product.categoryId }</td>
							<td>${product.name }</td>
							<td>${product.price }</td>
							<td>${product.discount }</td>
							<td>${product.status }</td>
							<td>${product.imageUrl }</td>
							<td>${product.description }</td>
							<td><a
								href='<c:url value="/website/deleteproduct.html"><c:param name="productId" value="${product.productId}"/><c:param name="idPage" value="${idpage }"/></c:url>'
								class="btn btn-danger">Delete</a></td>
							<td><a class="btn btn-success" href='<c:url value="/website/editproductget.html"><c:param name="name" value="${product.name}"/><c:param name="price" value="${product.price}"/><c:param name="productId" value="${product.productId}"/></c:url>'>Edit</a></td>
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