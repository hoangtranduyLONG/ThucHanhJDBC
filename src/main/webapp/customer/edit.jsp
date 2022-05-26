<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25/05/2022
  Time: 9:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h3>Sửa khách hàng</h3>
    <label>Mã người dùng</label>
    <input type="number" name="id" disabled value="${customer.id}">
    <br>
    <label>Tên người dùng: </label>
    <input type="text" name="name" value="${customer.name}">
    <br>
    <label>Tuổi người dùng: </label>
    <input type="number" name="age" value="${customer.age}">
    <br>
    <input type="submit" value="submit">
</body>
</html>
