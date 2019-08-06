
<%@ page import="java.util.List" %>
<%@ page import="entity.Message" %>
<%@ page import="entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>用户信息列表</title>
    <style>
        .table2{
            width: 700px;
            height: 300px;
            margin: 100px auto;
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
//    List<Message> list=messageslist;

%>
<div style="position:absolute;top: 0px;right: 0px;">
    <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" ></form><br>
    <form action="updateUser"method="post"><input type="submit" value="修改个人信息"></form>
    <a href="melist">返回留言列表</a>
</div>
<
<div class="table2">
    <!-- 表头	 -->
    <h2>用户信息列表</h2>

    <table cellpadding="0" cellspacing="0" border="1" width="100%">
        <!-- 第一行 -->
        <tr>
            <th>用户id</th>
            <th>姓名</th>
            <th>邮箱</th>
        </tr>
        <%
            if(list!=null) {
        %>

        <c:forEach items="<%=list%>" var="u">
            <tr>
                <th><c:out value="${u.id}"></c:out></th>
                <th><c:out value="${u.user_name}"></c:out></th>
                <th><c:out value="${u.email}"></c:out></th>
                    <%--                <th><a href="addMessage.jsp?list_id=${m.list_id}">编辑</a> </th>--%>
            </tr>
        </c:forEach>
        <% }%>
        <%-- <%}}%>--%>
    </table>


</div>
</body>
</html>

