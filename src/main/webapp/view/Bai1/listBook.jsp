<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sách trong thư viện</h1>
<a href="<c:url value='/BookController?action=add' />">Thêm sách mới</a>
<br/><br/>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>Thể loại</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td><c:out value="${book.id}" /></td>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.author}" /></td>
            <td><c:out value="${book.genre}" /></td>
            <td><c:out value="${book.quantity}" /></td>
            <td>
                <a href="<c:url value='/BookController?action=edit&id=${book.id}' />">Sửa</a>
                |
                <form action="<c:url value='/BookController?action=delete&id=${book.id}' />" method="post" style="display:inline;">
                    <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa sách này không?')">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
