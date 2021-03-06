<%@ page import="java.util.List" %>
<%@ page import="entity.Message" %>
<%@ page import="entity.User" %>
<%@ page import="entity.Access" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>留言列表</title>
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

<body>



<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
//    request.setAttribute("messagelist",messageslist);
    List<Message> list =(List<Message>)request.getSession().getAttribute("messList");
    User user = (User) request.getSession().getAttribute("User");
    List<User>users= (List<User>) request.getSession().getAttribute("userlist");
    List<Access> user_acc=user.getAccesses();
    List<Access> allAcc= (List<Access>) request.getSession().getAttribute("allAcc");
    int rid=user.getRid();
    System.out.println("我的用户是"+user.getUser_name()+rid);
    int [] gids=new int [allAcc.size()];
    String ac="ac";
    for (int j=0;j<allAcc.size();j++
         ) {
        gids[j]=0;
        for(int i=0;i<user_acc.size();i++){
          if(allAcc.get(j).getId()==user_acc.get(i).getId()){
          gids[j]=1;}
        }
    }
    /*System.out.println(gids.length);
    for (int i=0;i<gids.length;i++
         ) {
        System.out.println(gids[i]+" "+allAcc.get(i).getName());
    }*/


%>
<div style="position:absolute;top: 0;right: 0;">
    <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" class="btn btn-danger"></form><br>
    <%

        if(rid==1||gids[4]==1){
    %>
    <form action="userlist"><input type="submit" value="用户信息列表" class="btn btn-success"></form>
    <%}%>
    <%

        if(rid!=4){
    %>

    <form action="updateUser"method="post"><input type="submit" value="修改个人信息" class="btn btn-success"></form>
    <%}%>
    <% if(rid!=1){%>
    <form action="groupMess" method="post"><input type="submit" value="操作同组用户留言" class="btn btn-success"></form>
<%}%>
</div>
<div style="position: absolute;top: 0px;left: 250px">
    <%

            if(rid==1||gids[5]==1){
    %>
    <form method="get" action="findMessageByuser">
        输入用户名查找留言信息：
        <input type="search" name="serchmessage">
        <input type="submit" value="搜索" class="btn btn-info"><br>
    </form>
    <%}


    %>
    <form method="get" action="addMessage"><input type="submit" value="新建留言" class="btn btn-info"></form>

       <%
            if(rid==1||gids[6]==1){
    %>
    <form action="to_acc" method="get"><input type="submit" value="角色权限管理" class="btn btn-info"></form><%}%>
</div>
<div class="table1">
    <!-- 表头	 -->
    <h2>留言信息列表</h2>

    <table  class="table .table-striped table-hover table-bordered .table-responsive">
        <!-- 第一行 -->
        <thead>
        <tr>
            <th>留言序列</th>
            <th>留言标题</th>
            <th>留言内容</th>
            <%

                if(user.getRid()!=4){%>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>用户ID</th>
            <th>留言操作</th>
            <% } %>
        </tr>
        </thead>
        <%
            if(list!=null) {

                for (Message m:list
                ) {
        %>

        <tbody>
        <tr>
            <th><%=m.getId()%></th>
            <th><%=m.getTitle()%></th>
            <th><%=m.getContent()%></th>
            <th><%
                if(rid==1||gids[0]==1)
            {%>         <%=m.getCtime()%>

                <%}%></th>
            <th><%
                if(rid==1||gids[0]==1)
                {%>      <%=m.getUptime()%>

                <%}%></th>
            <th><%
                if(rid==1||gids[0]==1)
                {%>  <%=m.getUse_id()%>

                <%}%></th>
            <th><%

                if(rid==1||user.getId()==m.getUse_id()||gids[1]==1)
                {   /*if(gids[1]!=0){
                    System.out.println("权限是"+gids[1]);
                }*/
            %>
                <a href="updateMessage?id=<%=m.getId()%>"  >编辑</a><%}%>
                <%

                    if(rid==1||rid==2||user.getId()==m.getUse_id()||gids[2]==1)
                    {%>
                <a href="deleteMessage?delete_id=<%=m.getId()%>"  >删除</a><% }%>
            </th>



        </tr>
        </tbody>

        <% }}%>
        <%-- <%}}%>--%>
    </table>
    <a href="melist" class="btn btn-link">留言列表</a>

</div>


</body>
</html>
