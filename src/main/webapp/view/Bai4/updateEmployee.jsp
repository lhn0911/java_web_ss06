<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/EmployeeController?action=Update" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    Name: <input type="text" name="name" value="${employee.name}"><br>
    Birthday: <input type="date" name="birthday" value="${employee.birthday}"><br>
    Phone: <input type="text" name="phone" value="${employee.phone}"><br>
    Email: <input type="email" name="email" value="${employee.email}" readonly><br>
    Salary: <input type="number" name="salary" value="${employee.salary}"><br>
    Position: <input type="text" name="position" value="${employee.position}"><br>
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
