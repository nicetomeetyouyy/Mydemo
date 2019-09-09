<%@ page import="list.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
</head>
<body>
<div class="form">
    <h2>编辑您的用户信息</h2>
    <form action="userlist" method="get">
        <%
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            User user =(User) request.getAttribute("user");
        %>
        id:<br><input type="text" name="id" value="<%=user.getid()%>" ><br>
        user_name:<br><input type="text" name="uname"value="<%=user.getName()%>"><br>
        pwd:<br><input type="text" name="pwd"value="<%=user.getPassword()%> "><br>
        email:<br><input type="text" name="email" value="<%=user.getEmail()%>"><br>
        phone:<br><input type="text" name="phone" value="<%=user.getPhnumber()%>"><br>
        <br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">

    </form>
    <a href="userlist">返回用户列表</a>
</div>

</body>
</html>
