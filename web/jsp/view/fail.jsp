<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/9
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
</head>
<body>
<h1>失败,即将退回主界面!!</h1>
<%
    response.setHeader("refresh","2;URL=main.jsp?page=1");
%>
</body>
</html>
