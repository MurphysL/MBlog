<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/11
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%-- 增加向下跳转 --%>
<%@ page import="bean.Blog" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="blogs" class="bean.Blogs" scope="request"/>
<html>
<head>
    <meta charset="utf-8">
    <title>MBlog</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/yq.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <!-- Header -->
    <header>
        <%@include file="../weight/nav_login.jsp" %>
        <%@include file="../weight/banner.jsp"%>
    </header>
    <!-- Content -->
    <div id="yq_content">
        <div id="yq_inner">
            <%!
                private int i = 0;
            %>
            <%
                for(Blog blog : blogs.getBlogs()){
                    i ++;
                    String title = blog.getTitle();
                    String div_id = "yq_frg" + i;
                    String img_id = "f_img" + i;
                    String a_id = "f_title" + i;
                    String p_id = "f_des" + i;
                    Random random = new Random();
                    String main = blog.getArticle().substring(0, 20 + random.nextInt(10)) + "...";
            %>
                    <div id=<%=div_id%>>
                        <img src="../../img/pic1.jpg" id=<%=img_id%>>
                        <a id=<%=a_id%> class="title" href="BlogServlet?blog_id=3<%=blog.getBlog_id()%>"><%=title%></a>
                        <p id=<%=p_id%> class="des"><%=main%></p>
                    </div>
            <%
                }
                i = 0;
            %>
        </div>
    </div>
    <!-- Footer -->
    <%@include file="../weight/footer.jsp"%>
</div>

</body>
</html>
