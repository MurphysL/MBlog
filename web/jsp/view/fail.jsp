<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/9
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="error" class="bean.MError"/>
<html>
<head>
    <title>登录失败</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
</head>
<body>
<h1><jsp:getProperty name="user" property="username"/>登录失败,即将退回主界面!!</h1>
<h2>失败信息:<jsp:getProperty name="error" property="message"/> <jsp:getProperty name="error" property="code"/></h2>
<%
    response.setHeader("refresh","2;URL=../index.jsp");
%>
</body>
</html>
