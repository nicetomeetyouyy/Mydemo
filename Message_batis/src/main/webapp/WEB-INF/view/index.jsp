<%--
  Created by IntelliJ IDEA.
  User: xjm
  Date: 2019/7/30
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录界面</title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  response.setContentType("text/html;charset=UTF-8");
%>
<div style="width: 300px; margin:100px auto; ">
<form action="login"  method="post">
  用户名:
  <input type="text" name="username" id="username"><br>
  <input type="submit" name="登录" id="submit" >
</form>
</div>
<script>

  var sb=document.getElementById("submit");
  var username=document.getElementById("username");
  sb.onclick=function () {
    if(username.value.length==0||username.value==" "||username.value.length>4){
      alert("您的输入有误！请重新输入！用户名不要大于四个字符");
      return false;
    }
  }
</script>
</body>
</html>