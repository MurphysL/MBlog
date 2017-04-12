<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/3/3
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MBlog</title>
    <link rel="icon" href="img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/yq.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <script src="js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <%-- 注册 --%>
    <%@include file="jsp/weight/view_register.jsp"%>

    <%-- 登录 --%>
    <%@include file="jsp/weight/view_login.jsp"%>

    <%-- 首页 --%>
    <header>
        <%@include file="jsp/weight/nav_unlogin.jsp" %>
        <%@include file="jsp/weight/banner.jsp" %>
    </header>
</div>

</body>
</html>

