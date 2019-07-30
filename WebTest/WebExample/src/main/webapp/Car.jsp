<%--
  Created by IntelliJ IDEA.
  User: xjm
  Date: 2019/7/30
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.*" %>
<html>
<head>
    <title>购物车列表</title>
</head>
<body>
<div style="top: 0px;right: 0px;">
    欢迎:<c:out value="${username}"> </c:out>
    <a href="index.jsp"><input type="button" value="退出"></a>
</div>
 <h2>购物车列表页面</h2>
<br><br><br>
<table style="align-content: center">

    <tr>
        <th>商品名称</th>
        <th>价格</th>
    </tr>
    <%
        Cookie [] coo = request.getCookies();
        for (Cookie c:coo
        ) {
            String name =URLEncoder.encode(c.getName(),"UTF-8");
            String price =c.getValue(); %>
    <tr>
        <th><%= name%></th>
        <th><%= price%></th>
    </tr>
    <%
        }
    %>

</table>
<a href="add.jsp">
    <input type="button" value="返回">

</a>
</body>

</html>
