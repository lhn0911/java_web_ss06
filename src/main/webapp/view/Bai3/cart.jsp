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
<table>
  <tr><th>Name</th><th>Price</th><th>Quantity</th><th>Total</th><th>Action</th></tr>
  <c:forEach var="item" items="${cartDetails}">
    <tr>
      <td>${item.product.name}</td>
      <td>${item.product.price}</td>
      <td>${item.cart.quantity}</td>
      <td>${item.amount}</td>
      <td>
        <form action="cart" method="post">
          <input type="hidden" name="cartId" value="${item.cart.id}" />
          <button type="submit">Remove</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<p>Total: ${total}</p>
</body>
</html>
