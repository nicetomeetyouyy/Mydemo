<%@ page import="dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="list.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: xjm
  Date: 2019/7/31
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息列表</title>
    <style>
        .table{
            height: 300px;
            width: 600px;
            margin: 100px auto;
        }
    </style>
</head>
<body>
<div style="position:absolute;top: 0px;right: 0px;">
    <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" ></form>
</div>
<div class="table">
    <!-- 表头	 -->
    <h2>用户信息列表</h2>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<User> list =(List<User>) request.getAttribute("userlist");
    %>
    <table cellpadding="0" cellspacing="0" border="1" width="100%">
        <!-- 第一行 -->
        <tr>
            <th>用户id</th>
            <th>用户姓名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th>电话</th>
        </tr>
        <c:forEach items="<%=list%>" var="u">
            <tr>
            <th><c:out value="${u.getid()}"></c:out></th>
            <th><c:out value="${u.name}"></c:out></th>
            <th><c:out value="${u.password}"></c:out></th>
            <th><c:out value="${u.email}"></c:out></th>
            <th><c:out value="${u.phnumber}"></c:out></th>
        </tr>

        </c:forEach>
    </table>
    <a href="melist">返回留言列表</a>
</div>
</body>
</html>
