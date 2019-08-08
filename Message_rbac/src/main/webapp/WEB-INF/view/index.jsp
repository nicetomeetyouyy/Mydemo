<%--
  Created by IntelliJ IDEA.
  User: xjm
  Date: 2019/7/30
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>登录界面</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  response.setContentType("text/html;charset=UTF-8");
%>
<div style="width: 300px; margin:100px auto; ">
  <form action="login"  method="post" class="form-group">

    <label for="username">用户名:</label>
    <input type="text" name="username" id="username" class="form-control">

    <label for="pwd">密码:</label>
    <input type="password" name="pwd" id="pwd" class="form-control">
    <br>
    <input type="submit" name="登录" id="submit" class="btn btn-success">
  </form>
</div>

<script>

  var sb=document.getElementById("submit");
  var username=document.getElementById("username");
  var pwd=document.getElementById("pwd");
  sb.onclick=function () {
    if(username.value.length==0||username.value==" "){
      alert("您的输入有误！请重新输入！");
      return false;
    }
    if(pwd.value.length==0||pwd.value==" "){
      alert("您的输入有误！请重新输入！");
      return false;
    }
  }
</script>


</body>
</html>