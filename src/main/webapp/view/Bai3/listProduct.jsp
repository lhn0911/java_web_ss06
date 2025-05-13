<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/13/2025
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="p" items="${products}">
    <div>
        <img src="${p.imageUrl}" width="100" />
        <p>${p.name} - ${p.price}$</p>
        <form action="products" method="post">
            <input type="hidden" name="productId" value="${p.id}" />
            <button type="submit">Add to Cart</button>
        </form>
    </div>
</c:forEach>
</body>
</html>
