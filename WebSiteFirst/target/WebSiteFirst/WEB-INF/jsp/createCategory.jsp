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
	
	<h1>Create New Category :</h1>
	<h3 style="color:red">${message1 } ${message2 }</h3>
	<form:form action="createcategorynew.html" method="post" enctype="multipart/form-data"> 
	<table>
		<tr>
			<td>category name :</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		
		<tr>
			<td>status :</td>
			<td>
				<input type="text" name="status">
			</td>
		</tr>
		<tr>
			<td>Create New Category :</td>
			<td><input type="submit" value="Create Category"></td>
		</tr>
	</table>
	</form:form>
	<div class="row">
		<a href="category.html">Home</a>
	</div>
	<div class="row">
			${message }
	</div>
	
</body>
</html>