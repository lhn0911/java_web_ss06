<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/13/2025
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm sách mới</h1>
<form action="<c:url value='/BookController?action=create' />" method="post">
    <label>Tiêu đề:</label><br/>
    <input type="text" name="title" required/><br/><br/>

    <label>Tác giả:</label><br/>
    <input type="text" name="author" required/><br/><br/>

    <label>Thể loại:</label><br/>
    <input type="text" name="genre" required/><br/><br/>

    <label>Số lượng:</label><br/>
    <input type="number" name="quantity" min="0" required/><br/><br/>

    <button type="submit">Thêm sách</button>
</form>
<br/>
<a href="<c:url value='/BookController' />">Quay lại danh sách</a>
</body>
</html>
