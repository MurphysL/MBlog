<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/10
  Time: 7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="blog" class="bean.Blog" scope="request"/>
<!DOCTYPE HTML>
<html>
<head>
    <title>MBlog</title>
    <meta charset="utf-8" />
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/yq.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
</head>
<body>

<!-- Header -->
<div id="main_bg">
    <nav>
        <div id="logo">
            <a href="#" >MurphySL</a>
        </div>
        <ul>
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
            <li><a href="#" onclick="register()">删除</a></li>
            <li><a href="#" onclick="login()">修改</a></li>
        </ul>
    </nav>
</div>


<!-- Main -->
<section id="main">
    <div class="inner">
        <div class="image fit">
            <img src="../../img/pic1.jpg" alt="" />
        </div>
        <header>
            <h1><%=blog.getTitle()%></h1>
            <%--<p class="info">3 days ago by <a href="#">Jane Doe</a></p>--%>
        </header>
        <p><%=blog.getArticle()%></p>
    </div>
</section>

<!-- Footer -->
<%@include file="../weight/footer.jsp"%>

</body>
</html>
