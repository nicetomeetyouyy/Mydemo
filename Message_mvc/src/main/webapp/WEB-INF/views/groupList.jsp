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
    List<Message> list =(List<Message>)request.getSession().getAttribute("groupList");
    User user = (User) request.getSession().getAttribute("User");
    List<Access> user_acc=user.getAccesses();
    List<Access> allAcc= (List<Access>) request.getSession().getAttribute("allAcc");
    int [] gids=new int [allAcc.size()];
    for (int j=0;j<allAcc.size();j++
         ) {
        gids[j]=0;
        for(int i=0;i<user_acc.size();i++){
          if(allAcc.get(j).getId()==user_acc.get(i).getId()){
          gids[j]=1;}
        }
    }
    //    List<Message> list=messageslist;

%>
<div style="position:absolute;top: 0;right: 0;">
    <% String names =(String)session.getAttribute("username");%>
    欢迎:<%= names %>
    <form action="LogginOut" method="get"><input type="submit" value="退出" class="btn btn-danger"></form><br>
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
            <th>创建时间</th>
            <th>更新时间</th>
            <th>用户ID</th>
            <th>留言操作</th>
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
            <th>   <%=m.getCtime()%>

               ></th>
            <th>    <%=m.getUptime()%>

                </th>
            <th>  <%=m.getUse_id()%>

                </th>
            <th><%

                if(user.getId()==m.getUse_id()||gids[13]==1)
                {   /*if(gids[1]!=0){
                    System.out.println("权限是"+gids[1]);
                }*/
            %>
                <a href="updateMessage?id=<%=m.getId()%>"  >编辑</a><%}%>
                <%

                    if(user.getId()==m.getUse_id()||gids[12]==1)
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
