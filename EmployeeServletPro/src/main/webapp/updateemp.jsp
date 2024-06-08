<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/EmployeeServletPro/SaveEmp">
eid:<input type="text" name="eid" value="${emp.id}"><br>
ename:<input type="text" name="ename" value="${emp.name}"><br>
age:<input type="text" name="age" value="${emp.age}"><br>
salary:<input type="text" name="salary" value="${emp.salary}"><br>
<input type="submit" value="update">
</form>
</body>
</html>