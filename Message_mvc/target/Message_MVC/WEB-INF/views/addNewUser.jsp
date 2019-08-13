<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="entity.User" %>
<%@ page import="entity.Role" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<div class="form" style="width: 300px; margin: 50px auto">
    <h2>修改用户信息</h2>
    <form action="addToUser" method="post" class="form-group">
        <%
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            List<Role> list_ro= (List<Role>) request.getSession().getAttribute("roleList");
        %>
        <label for="uname">用户名:</label>
        <input type="text" name="uname" id="uname"  class="form-control">

        <label for="pwd">密码:</label>
        <input type="text" name="pwd"  id="pwd"  class="form-control">

        <label for="email">邮箱:</label>
        <input type="text" name="email"  id="email"  class="form-control">

        <label for="phone">电话:</label>
        <input type="text" name="phone"  id="phone"  class="form-control">
        <br>
        <label for="role">身份</label>
        <%
            for (Role r:list_ro
            ) {  %>
        <input type="radio" name="role" id="role" value="<%=r.getId()%>" ><%=r.getName()%>
        <% }
        %>
        <%--        <input type="radio" name="role" checked id="role">超级管理员--%>
        <%--        <input type="radio" name="role" id="role">管理员--%>

        <br>
        <label for="group">组别</label>
        <input type="text" name="group"  id="group" class="form-control">
        <input type="submit" value="提交" class="btn btn-success">
        <input type="reset" value="重置" class="btn btn-danger">

    </form>
    <a href="userlist" class="btn btn-link">返回用户列表</a>
</div>



</body>
</html>
