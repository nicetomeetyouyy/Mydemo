<%@ page import="java.util.List" %>
<%@ page import="entity.Access" %>
<%@ page import="entity.Role" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改角色信息</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<div class="form" style="width: 300px; margin: 50px auto">
    <h2>角色权限信息</h2>
    <form action="updateToRole" method="post" class="form-group">
        <%
            List<Access>role_acc= (List<Access>) request.getSession().getAttribute("accList");
            List<Access>accesses= (List<Access>) request.getSession().getAttribute("allAcc");
            Role role = (Role) request.getSession().getAttribute("Role");
            int length =accesses.size();
        %>
        <label for="rname">角色名称:</label>
        <input type="text" name="rname" id="rname"  class="form-control" value="<%=role.getName()%>">
        <%
            for (int i=0;i<length;i++
            ) {
                Access a=accesses.get(i);
        %>
        <label for="role<%=i%>">权限</label>
        <input type="checkbox" name="role<%=i%>" id="role<%=i%>" value="<%=a.getId()%>"
        <%
            for (Access b :role_acc ) {
              if(a.getId()==b.getId()){
            %>checked
               <%}}%>
        ><%=a.getName()%><br>
        <% }%>
        <input type="submit" value="提交" class="btn btn-success">
        <input type="reset" value="重置" class="btn btn-danger">

    </form>
    <a href="to_acc" class="btn btn-link">返回角色列表</a>
</div>



</body>
</html>

