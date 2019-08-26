<%@ page import="entity.Moneys" %><%--
  Created by IntelliJ IDEA.
  User: YY
  Date: 2019/8/25
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>打赏用户</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<div style="width: 300px; margin: 50px auto">
    <% Moneys money = (Moneys) request.getAttribute("money");
      int adduser= (int) request.getAttribute("addUser");
      request.getSession().setAttribute("addUser",adduser);
    %>
    <label >您的余额:</label><%=money.getMoney()%><br>
    <form action="costToMoney" method="post">
        <input type="text" name="costMoney"><input type="submit" value="打赏">
    </form>


    <a href="melist" class="btn btn-link">返回留言</a>
</div>
</body>
</html>
