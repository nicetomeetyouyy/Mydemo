<%@ page import="entity.User" %>
<%@ page import="entity.Image" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<div class="form" style="width: 300px; margin: 50px auto">
    <h2>编辑您的用户信息</h2>
    <%
        Image image= (Image) request.getSession().getAttribute("useImage");
        if(image==null){
    %>
    <img src="585747cfd354024.jfif" width="30" height="40"/><% }else {%>
    <img src="<%=image.getFilename()%>"width="30" height="40"/><%}%>
    <a href="uploadimage"><button  class="btn btn-success">修改头像</button> </a>
    <form action="updatetoUser" method="get" class="form-group">
        <%
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            User user =(User) request.getSession().getAttribute("User");
        %>
        <label for="uname">用户名:</label>
        <input type="text" name="uname" id="uname" value="<%=user.getUser_name()%>" class="form-control">

        <label for="pwd">密码:</label>
        <input type="text" name="pwd"  id="pwd" value="<%=user.getPwd()%> " class="form-control">

        <label for="email">邮箱:</label>
        <input type="text" name="email"  id="email" value="<%=user.getEmail()%>" class="form-control">

        <label for="phone">电话:</label>
        <input type="text" name="phone"  id="phone" value="<%=user.getPhone()%>" class="form-control">
        <br>
        <input type="submit" value="提交" class="btn btn-success">
        <input type="reset" value="重置" class="btn btn-danger">

    </form>
    <a href="melist" class="btn btn-link">返回留言</a>
</div>
</body>
</html>
