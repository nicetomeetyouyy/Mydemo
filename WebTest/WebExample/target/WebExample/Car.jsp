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
<div style="position:absolute;top: 0px;right: 0px;">
    <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LoginOut" method="get"><input type="submit" value="退出" ></form>
</div>
<h2 style= "text-align: center;">购物车列表页面</h2>
<br><br><br>
<table style="width: 300px;margin: 100px auto;text-align: center; border: 10px ;solid-color: black">

    <tr>
        <th>商品名称</th>
        <th>价格</th>
    </tr>
    <%
        Cookie [] coo = request.getCookies();
        for (int i=1;i<coo.length;i++
        ) {
            Cookie c=coo[i];
            String name =URLDecoder.decode(c.getName(),"UTF-8");
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
