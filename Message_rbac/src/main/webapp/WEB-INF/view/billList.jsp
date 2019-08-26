<%@ page import="java.util.List" %>
<%@ page import="entity.Bill" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/26
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账单信息</title>
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
<div style="position:absolute;top: 0;right: 0;">
        <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" class="btn btn-danger"></form><br>
</div>
<div class="table1">
    <!-- 表头	 -->
    <h2>用户信息列表</h2>
    <%
        List<Bill>list= (List<Bill>) request.getAttribute("bill");
    %>
    <table class="table table-striped table-hover table-bordered">
        <!-- 第一行 -->
        <thead>
        <tr>
            <th>id</th>
            <th>类型</th>
            <th>金额</th>
            <th>时间</th>
        </tr>
        <%
        if(list!=null){
            for (Bill b:list
                 ) {
                %>
        <tr>
            <th><%=b.getId()%></th>
            <th><%=b.getType()%></th>
            <th><%=b.getAmount()%></th>
            <th><%=b.getTime()%></th>
        </tr>
        <%
            }
        }
        %>
        </thead>
    </table>
    <a href="melist" class="btn btn-link">留言列表</a>
</div>
</body>
</html>
