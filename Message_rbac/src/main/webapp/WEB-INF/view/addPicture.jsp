<%@ page import="entity.Image" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/19
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<div class="form" style="width: 300px; margin: 50px auto">
    <h2>上传您的新头像</h2>
    <form action="addImage" method="post" class="form-group" enctype="multipart/form-data">
        <label for="picture">上传新头像:</label>
        <input type="file" name="picture" id="picture" class="form-control"><br>
        <input type="submit" value="提交" class="btn btn-success">
    </form>
   <%-- <%
        List<Image> list=new ArrayList<>();
        try {
            list= (List<Image>) request.getSession().getAttribute("images");
        }catch (Exception e){
            System.out.println("找不到对象images");
        }
        if(list.size()!=0){
    %>--%>
    <form action="updateImage" method="post" class="form-group">
     <label>历史头像</label><br>
        <% List<Image>list= (List<Image>) request.getSession().getAttribute("images");
        if(list!=null){
            for (Image i:list
                 ) {
        %>
         <input type="radio" name="imageHistory" value="<%=i.getId()%>" <%if(
                 i.getIs_used()==1){%>checked<%}%>/><img src="<%=i.getFilename()%>" width="30" height="40">
        <a href="deleteImage?image_id=<%=i.getId()%>">删除</a><br>
        <%}}
        %>
        <input type="submit" value="修改" class="btn btn-success" >
    </form>
    <a href="melist" class="btn btn-link">返回留言</a>
</div>
</body>
</html>

