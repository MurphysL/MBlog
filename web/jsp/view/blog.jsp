<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/9
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="bean.Blog" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <title>MBlog</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/yq.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body style="background-color: #023D59">
<div id="main_bg">
    <!-- Nav -->
    <%@include file="../weight/nav_login.jsp"%>
    <%-- Content --%>
    <div id="yq_content">
        <div id="yq_inner">
            <%
                //List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");
                for(int i = 0 ;i < 2 ;i ++){
            %>
            <div id="yq_blog">
                <img src="../../img/pic1.jpg" id="f_img1">
                <a id="f_title1" class="title" href="article.jsp">从前有座山</a>
                <p id="f_des1" class="des">Lorem ipsum dolor sit amet...</p>
            </div>
            <%
                }
            %>
        </div>
    </div>
    <%-- Footer --%>
    <%@include file="../weight/footer.jsp"%>
</div>

</body>
</html>
