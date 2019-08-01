<%--
  Created by IntelliJ IDEA.
  User: XJM
  Date: 2019/7/29
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<div style="position:absolute;top: 0px;right: 0px;">
    <% String names =(String) session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LoginOut" method="get"><input type="submit" value="退出" ></form>
</div>
</div>
<form style="width: 300px;margin: 100px auto;text-align: center;"action="add" method="get">
    请输入商品名称:
    <input type="text" name="thing">
    <input type="submit" value="添加">
</form>
</body>
</html>
