<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Create New Product :</h1>
	<h3 style="color:red">${message1 } ${message2 }</h3>
	<form:form action="editproduct.html" method="post" enctype="multipart/form-data"> 
	<table>
		<tr>
			<td></td>
			<td>
				<input type="hidden" name="productId" value="${productId}">
			</td>
		</tr>
		<tr>
			<td>category :</td>
			<td>
				<select name="selectCategory">
					<c:forEach var="listCategory" items="${listCategory}">
						<option value="${listCategory.categoryId}">${listCategory.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>name :</td>
			<td><input type="text" name="name" placeholder="${name }" ></td>
		</tr>
		<tr>
			<td>price :</td>
			<td><input type="text" name="price" placeholder="${price }" ></td>
		</tr>
		<tr>
			<td>discount :</td>
			<td>
				<select name="selectDiscount">
					<c:forEach var="i" begin="1" end="100" step="1">
						<option value="${i}">${i} %</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>status :</td>
			<td>
				<select name="selectStatus">
					<option value="con">Con Hang</option>
					<option value="het">Het Hang</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>description :</td>
			<td>
				<select name="selectDescription">
					<option value="hot deals">Hot Deal</option>
					<option value="special offer">Special Offer</option>
					<option value="new">New</option>
					<option value="feature">Feature</option>
					<option value="arrivals">Arrivals</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><label>Choose Image :</label></td>
			<td><input type="file" name="imageUrl"></td>
		</tr>
		<tr>
			<td>Update Product :</td>
			<td><input type="submit" value="Update"></td>
		</tr>
	</table>
	</form:form>
	<div class="row">
		<a href="admin.html">Home</a>
	</div>
	<div class="row">
			${message }
	</div>
	
</body>
</html>