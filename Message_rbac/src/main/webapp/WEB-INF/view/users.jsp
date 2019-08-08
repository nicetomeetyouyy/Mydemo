
<%@ page import="java.util.List" %>
<%@ page import="entity.Message" %>
<%@ page import="entity.User" %>
<%@ page import="entity.Role" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户信息列表</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        .table1{
            width: 75%;
            /*height: 300px;*/
            margin: 100px auto;
            text-align: center;
        }
        th{
            text-align: center;
        }
    </style>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
//    request.setAttribute("messagelist",messageslist);
    List<User> list =(List<User>)request.getSession().getAttribute("userlist");
    List<Role> list_ro= (List<Role>) request.getSession().getAttribute("roleList");
    User user = (User) request.getSession().getAttribute("User");
    int rid=user.getRid();
    //    List<Message> list=messageslist;

%>
<div style="position:absolute;top: 0;right: 0;">
    <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" class="btn btn-danger"></form><br>
    <form action="updateUser" method="post"><input type="submit" value="修改个人信息" class="btn btn-info"></form>
    <% if (rid==1){%>
    <form action="userManager" method="get"><input type="submit" value="添加用户" class="btn btn-info"></form>
    <%}%>
    <a href="melist" class="btn btn-link">返回留言列表</a>
</div>
<div class="table1">
    <!-- 表头	 -->
    <h2>用户信息列表</h2>

    <table class="table table-striped table-hover table-bordered">
        <!-- 第一行 -->
        <thead>
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>手机</th>
            <th>密码</th>
            <th>身份</th>
            <th>组别</th>
            <th>编辑</th>
            <th>删除</th>
        </tr>
        </thead>
        <%
            if(list!=null) {
                for (User u:list
                ) {
                    System.out.println(u.getRid()-1);
                    Role role=list_ro.get(u.getRid()-1);

        %>
        <tbody>
        <tr>
            <th><%if(rid==1){%>
                <%=u.getId()%>
                <%}%></th>
            <th><%=u.getUser_name()%></th>
            <th><%=u.getEmail()%></th>
            <th><%=u.getPhone()%></th>

            <th>
                <%
                    if(rid==1){
                %>
                <%=u.getPwd()%>
                <%}%></th>
            <th><%if(rid==1){%>
                <%=role.getName()%>
                <%}%></th>
            <th><%if(rid==1){%>
                <%=u.getGid()%>
                <%}%></th>
            <th><%if(rid==1){%>
                <a href="updateUserAll?name=<%=u.getUser_name()%>">编辑</a>
                <%}%></th>
            <th><%if(rid==1){%>
                <a href="userDelete?id=<%=u.getId()%>">删除</a>
                <%}%></th>
            <% }}%>
        </tr>
        </tbody>
        <%-- <%}}%>--%>
    </table>

</div>
</body>
</html>

