<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/13/2025
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Oẳn Tù Tì - Kết quả</h1>
<p><strong>Chọn của bạn:</strong> <%= request.getAttribute("userChoice") %></p>
<p><strong>Lựa chọn của máy tính:</strong> <%= request.getAttribute("computerChoice") %></p>
<p><strong>Kết quả:</strong> <%= request.getAttribute("result") %></p>

<a href="GameController">Chơi lại</a>
</body>
</html>
