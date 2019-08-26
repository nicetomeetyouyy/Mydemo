<%@ page import="entity.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Access" %><%--
  Created by IntelliJ IDEA.
  User: YY
  Date: 2019/8/8
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加角色</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<%
    List<Role> list_ro= (List<Role>) request.getSession().getAttribute("roleList");
    List<Access> acclist =(List<Access>) request.getSession().getAttribute("allAcc");
    int length=acclist.size();
%>
<body>
<div class="form" style="width: 300px; margin: 50px auto">
    <h2>添加角色信息</h2>
    <form action="addRole" method="post" class="form-group">
        <label for="rname">角色名称:</label>
        <input type="text" name="rname" id="rname"  class="form-control">

            <%
            for (int i=0;i<length;i++
            ) {
                Access a=acclist.get(i);
%>
        <label for="role<%=i%>">权限</label>
        <input type="radio" name="role<%=i%>" id="role<%=i%>" value="<%=a.getId()%>" ><%=a.getName()%>
<% }%>

        <br>
        <input type="submit" value="提交" class="btn btn-success">
        <input type="reset" value="重置" class="btn btn-danger">

    </form>
    <a href="to_acc" class="btn btn-link">返回角色列表</a>
</div>



</body>
</html>
