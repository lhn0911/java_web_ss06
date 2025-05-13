<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/13/2025
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chơi Oẳn Tù Tì</h1>
<form action="GameController" method="POST">
    <label for="choice">Chọn của bạn:</label>
    <select name="choice" id="choice">
        <option value="búa">Búa</option>
        <option value="lá">Lá</option>
        <option value="kéo">Kéo</option>
    </select>
    <button type="submit">Chơi</button>
</form>
</body>
</html>
