<%@ page import="entity.Message" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建留言</title>

</head>
<body>
<div style="position:absolute;top: 0px;right: 0px;">
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" ></form>
</div>
<%
    Message message =(Message) request.getAttribute("message");
    String title=null;
    String content=null;
    if(message!=null){
        String title_id=String.valueOf(message.getId());
        request.setAttribute("list_id",title_id);
        title =message.getTitle();
        content =message.getContent();
    }
%>
<div >
    <h2>编辑您的留言信息</h2>
    <form action="newMessage" method="post">

        标题:<br><input type="text" name="title" value=<%=title%> ><br>
        留言内容:<br><input type="text" name="content" value=<%=content%>>
        <br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">

    </form>
    <a href="melist">返回留言列表</a>
</div>


</body>
</html>
