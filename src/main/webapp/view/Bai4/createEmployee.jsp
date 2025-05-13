<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/13/2025
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm nhân viên</h2>
<form action="<%=request.getContextPath()%>/EmployeeController?action=Create" method="post">
  Name: <input type="text" name="name"><br>
  Birthday: <input type="date" name="birthday"><br>
  Phone: <input type="text" name="phone"><br>
  Email: <input type="email" name="email"><br>
  Salary: <input type="number" name="salary"><br>
  Position: <input type="text" name="position"><br>
  <button type="submit">Thêm nhân viên</button>
</form>
</body>
</html>
