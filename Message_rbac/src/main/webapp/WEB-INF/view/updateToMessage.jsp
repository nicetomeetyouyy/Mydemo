<%@ page import="entity.Message" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>留言列表</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        .form-input{
            height: 150px;
        }

    </style>
</head>
<html>
<head>
    <title>修改留言</title>

</head>
<body>
<div style="position:absolute;top: 0px;right: 0px;">
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String names =(String)request.getSession().getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" class="btn btn-danger"></form>
</div>
    <%
Message message =(Message) request.getSession().getAttribute("Message");

%>
<div style="width: 300px;margin: 50px auto">
    <h2>修改您的留言信息</h2>
    <form action="updateToMessage" method="post" class="form-group">
        <label for="title">标题:</label>
        <input type="text" name="title" id="title" value="<%=message.getTitle()%>" class="form-control" placeholder="请输入标题">

        <label for="content">留言内容:</label>
        <input type="text" name="content" id="content" value="<%=message.getContent()%>" class="form-control form-input">
        <br>
        <input type="submit" value="提交" class="btn btn-success">
        <input type="reset" value="重置" class="btn btn-danger">



    </form>
        <a href="melist" class="btn btn-link">返回留言列表</a>
        </div>



        </body>
        </html>