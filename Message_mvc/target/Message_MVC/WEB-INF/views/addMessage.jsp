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
    <title>新建留言</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div style="position:absolute;top: 0;right: 0;">
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出"  class="btn btn-danger"></form>
</div>

<div style=" width: 400px; margin: 0 auto">
    <h2>编辑您的留言信息</h2>
    <form action="newMessage" method="post" class="form-group">

        <label for="title">标题</label><br>
        <input type="text" name="title"  id="title"  style="width: 340px" ><br>

        <label for="content">留言内容:</label><br>
        <!--<input type="" name="content" id= "content" class="form-control">-->
        <textarea name="content" id="content" cols="45" rows="10" style="resize: none"></textarea>
        <br><br>
        <input type="submit"  class="btn btn-success" value="提交" >

        <input type="reset"  class="btn btn-danger" value="重置">

    </form>
    <a href="melist">返回留言列表</a>
</div>



</body>
</html>
