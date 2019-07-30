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
<div style="top: 0px;right: 0px;">
    欢迎:<c:out value="${username}"> </c:out>
    <a href="index.jsp"><input type="button" value="退出"></a>
</div>
<form style="align-content: center " action="add" method="get">
    请输入商品名称:
    <input type="text" name="thing">
    <input type="submit" value="添加">
</form>
</body>
</html>
