<%@ page import="java.util.List" %>
<%@ page import="entity.Operation" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/15
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户操作日志</title>
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
<%
    List<Operation> list= (List<Operation>) request.getAttribute("opeList");
%>
<body>
<div style="position:absolute;top: 0;right: 0;">
        <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" class="btn btn-danger"></form></div>

<div style="position: absolute;top: 0px;left: 250px">
    <form method="get" action="findOpe">
                    输入操作类型
        <input type="search" name="search">
        <input type="submit" value="搜索操作" class="btn btn-info"><br>
    </form>
    <a href="melist" class="btn btn-link">返回留言列表</a>
    <a href="opelist" class="btn btn-link">操作日志</a>
</div>
<div class="table1" >

    <h2>用户操作日志</h2>
    <table  class="table .table-striped table-hover table-bordered .table-responsive">
        <tr>
            <th>操作序列</th>
            <th>操作用户</th>
            <th>用户ID</th>
            <th>创建时间</th>
            <th>操作类型</th>
            <th>耗时</th>
            <th>操作结果</th>
        </tr>
        <% if(list!=null){
            for (Operation o:list
                 ) {
        %>
        <tr>
            <th><%=o.getId()%></th>
            <th><%=o.getUser_name()%></th>
            <th><%=o.getUser_id()%></th>
            <th><%=o.getNowtime()%></th>
            <th><%=o.getOpe()%></th>
            <th><%=o.getTime()%></th>
            <th><%=o.getResult()%></th>
        </tr><%}}%>
    </table>

</div>



</body>
</html>
