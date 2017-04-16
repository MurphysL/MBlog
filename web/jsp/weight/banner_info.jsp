<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/16
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="self_blogs_num" class="bean.ArticleNum" scope="session"/>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<div id ="yq_banner">
    <div>
        <img src=<%=user.getAvatar()%> style="width:150px;height:150px;border-radius:75px;">
        <h1><%=user.getUsername()%></h1>
        <h4 style="margin-top: 60px;color: white;align-items: center;text-align: center;">
            <%=user.getEmail()%></h4>
        <h4 style="margin: 0;color: white;align-items: center;text-align: center;">
            发表文章 <%=self_blogs_num.getNum()%> 篇</h4>
    </div>
</div>
