<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<style>

	a {
	    text-decoration: none;
	    padding: 1.8px 9px;
	    border-radius: 3.5px;
	    font-size: 14px;
	    color: black;
	}
	
	a[href*="edit"] {
	    background-color: grey;
	}
	
	a[href*="delete"] {
	    background-color: grey;
	}
</style>

</head>
<body>
	
	<h2>Employee List</h2>
	
	<table border = "1">
	<tr>
	    <th>ID</th>
	    <th>Name</th>
	    <th>Phone</th>
	    <th>Email</th>
	    <th>Update</th>
	    <th>Delete</th>
	</tr>
	
	<c:forEach var="emp" items="${employees}">
	<tr>
	    <td>${emp.id}</td>
	    <td>${emp.name}</td>
	    <td>${emp.phone}</td>
	    <td>${emp.email}</td>
	    <td><a href="edit?id=${emp.id}">Update</a></td>
	    <td><a href="delete?id=${emp.id}">Delete</a></td>
	</tr>
	</c:forEach>
	</table>

</body>
</html>