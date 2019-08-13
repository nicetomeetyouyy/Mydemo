<%@ page import="java.util.List" %>
<%@ page import="entity.Role" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>留言列表</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        .table1{
            width: 1000px;
            /*height: 300px;*/
            margin: 100px auto;
            text-align: center;
        }

    </style>
</head>

<body>

<%
    List<Role> list= (List<Role>) request.getSession().getAttribute("roleList");
%>


<div style="position: absolute;top: 0px;left: 250px">
    <div style="position:absolute;top: 0;right: 0;">
        <% String names =(String)session.getAttribute("username");%>
        欢迎:<%= names %>
        <form action="LogginOut" method="get"><input type="submit" value="退出" class="btn btn-danger"></form><br>
    <form method="get" action="roleManager"><input type="submit" value="新建角色" class="btn btn-info"></form>
</div>
<div class="table1">
    <!-- 表头	 -->
    <h2>留言信息列表</h2>

    <table  class="table .table-striped table-hover table-bordered .table-responsive">
        <!-- 第一行 -->
        <thead>
        <tr>
            <th>角色ID</th>
            <th>角色名称</th>
            <th>编辑权限</th>
            <th>删除角色</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Role r:list
                 ) {
        %>
        <tr>
           <th><%=r.getId()%></th>
            <th><%=r.getName()%></th>
            <th><a href="updateRole?rid=<%=r.getId()%>">修改权限</a> </th>
            <th><a href="deleteRole?rid=<%=r.getId()%>">删除角色</a> </th>
        </tr>
        <%}%>
        </tbody>
    </table>
    <a href="melist" class="btn btn-link">留言列表</a>

</div>


</body>
</html>
