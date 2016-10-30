<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h1>Hello Admin Category</h1>
		</div>
	
		<div class="row">
			<p><a class="btn btn-success" href="1.html?select=">Manager Product</a></p>
		</div>
		<div class="row" style="margin-top: 50px">
			<div class="col-md-12">
				<div class="row">
					<a
						href="<%=request.getContextPath()%>/website/admin/createcategory.html">Create
						new Record</a>
				</div>
				<div class="row">
					<table>
						<thead>
							<th>CategoryId</th>
							<th>Name</th>
							<th>Status</th>
						</thead>
						<tbody>
							<c:forEach var="category" items="${listCategory }">
								<tr>
									<td>${category.categoryId }</td>
									<td>${category.name }</td>
									<td>${category.status }</td>
									<td><a class="btn btn-danger" href='<c:url value="deletecategory.html"><c:param name="categoryId" value="${category.categoryId}"/></c:url>'>Delete</a></td>
									<td><a class="btn btn-success" href="">Edit</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="row" style="margin-top:20px">
					<a class="btn btn-primary"
						href="<%=request.getContextPath()%>/website/index.html">Home</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>