<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/14
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="bean.Blog" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="self_blogs" class="bean.Blogs" scope="session"/>
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
        <%@include file="../weight/banner_info.jsp"%>
    </header>
    <!-- Content -->
    <div id="yq_content">
        <div id="yq_inner">
            <%
                for(int i = 1 ;i <= 4 ;i ++){
                    String div_id = "yq_frg" + i;
                    String img_id = "f_img" + i;
                    String a_id = "f_title" + i;
                    String p_id = "f_des" + i;
                    if(i-1 < self_blogs.getBlogs().size()){
                        Blog blog = self_blogs.getBlogs().get(i-1);
                        String title = blog.getTitle();
                        Random random = new Random();
                        String main = blog.getArticle().toCharArray().length >= 20?
                                blog.getArticle().substring(0, 20 + random.nextInt(10)) + "..."
                                :blog.getArticle();
            %>
            <div id=<%=div_id%>>
                <img src="../../img/pic1.jpg" id=<%=img_id%>>
                <a id=<%=a_id%> class="title" href="../../servlet/SelfMainServlet?blog_id=<%=blog.getBlog_id()%>"><%=title%></a>
                <p id=<%=p_id%> class="des"><%=main%></p>
            </div>
            <%
            }else{
            %>
            <div id=<%=div_id%>></div>
            <%
                    }
                }
            %>
        </div>
    </div>
    <!-- Bar -->
    <%@include file="../weight/bar.jsp"%>
</div>

</body>
</html>
