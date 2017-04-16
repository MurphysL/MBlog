<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/11
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <div id="logo">
        <a href="../../servlet/MainServlet?page=1" >MBlog</a>
    </div>
    <div id="avatar">
        <a href="../../servlet/SelfMainServlet?page=1">
            <img src=<%=((User)request.getSession().getAttribute("user")).getAvatar()%>>
        </a>
    </div>
    <div id="new">
        <a href="../view/editor.jsp"><img src="../../img/cancel.png"></a>
    </div>
</nav>
