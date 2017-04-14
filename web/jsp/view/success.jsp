<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/13
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除成功</title>
</head>
<body>
<h1><%--<jsp:getProperty name="user" property="username"/>--%>成功</h1>
<%
    response.setHeader("refresh","2;URL=../../servlet/MainServlet?page=1");
%>
</body>
</html>
