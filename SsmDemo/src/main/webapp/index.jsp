<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
${requestScope.req}<br>
${sessionScope.session}<br>
${requestScope.map}<br>
${requestScope.model}<br>
${requestScope.mav}
<%System.out.println("jsp");%>
<a href="download?fileName=a.txt">下载</a>
<form action="upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit" value="提交">
</form>
</body>
</html>
