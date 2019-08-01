<%@ page import="list.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.MessageDao" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>留言列表</title>
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

//    request.setAttribute("messagelist",messageslist);
    List<Message> list =(List<Message>)request.getAttribute("messList");
//    List<Message> list=messageslist;

%>
<div style="position:absolute;top: 0px;right: 0px;">
    <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" ></form><br>
    <form action="userlist"method="post"><input type="submit" value="修改个人信息"></form>
</div>
<div style="position: center">
    <form method="get" action="melist">
        输入用户名查找留言信息：
        <input type="search" name="serchmessage">]
        <input type="submit" value="搜索"><br>
    </form>
    <form action="userlist"><input type="submit" value="用户信息列表"></form>
</div>
<div class="table2">
    <!-- 表头	 -->
    <h2>留言信息列表</h2>

    <table cellpadding="0" cellspacing="0" border="1" width="100%">
        <!-- 第一行 -->
        <tr>
            <th>留言序列</th>
            <th>留言标题</th>
            <th>留言内容</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>用户ID</th>
            <th>删除留言</th>
        </tr>
         <%--<%
             if(list!=null){
             for (Message m:list
                 ) {%>--%>

   <c:forEach items="<%=list%>" var="m">
            <tr>
                <th><c:out value="${m.list_id}"></c:out></th>
                <th><c:out value="${m.title}"></c:out></th>
                <th><c:out value="${m.content}"></c:out></th>
                <th><c:out value="${m.ctime}"></c:out></th>
                <th><c:out value="${m.uptime}"></c:out></></th>
                <th><c:out value="${m.user_id}"></c:out></th>
                <th><a href="melist?delete_id=${m.list_id}">删除</a> </th>
<%--                <th><a href="addMessage.jsp?list_id=${m.list_id}">编辑</a> </th>--%>
            </tr>
   </c:forEach>
      <%-- <%}}%>--%>
    </table>
    <form method="get" action="addMessage.jsp"><input type="submit" value="新建留言"></form>
</div>
</body>
</html>
