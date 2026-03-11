<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Employee</h1>
	<form action="updateEmployee" method="post">
    	<input readOnly = "true" name="id" value="${employee.id}"><br>
    	Name : <input type="text" name="name" value="${employee.name}"><br>
    	Phone : <input type="text" name="phone" value="${employee.phone}"><br>
    	Email : <input type="text" name="email" value="${employee.email}"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>