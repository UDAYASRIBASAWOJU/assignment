<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register Employee</h1>
	<form action="saveEmployee" method="post">
		Name: <input type="text" name="name"><br> 
		Phone: <input type="text" name="phone"><br> 
		Email: <input type="text" name="email"><br> 
		<input type="submit" value="Register">
	</form>
</body>
</html>