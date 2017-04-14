<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/14
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="editor_blog" class="bean.Blog" scope="session"/>
<div id="main">
    <div class="inner">
        <form action="../../servlet/CommitUpdateServlet?blog_id=<%=editor_blog.getBlog_id()%>" method="post">
            <input type="text" name="title" id="title" placeholder="文章标题"
                   value=<%=editor_blog.getTitle()==null?"":editor_blog.getTitle()%>>
            <textarea name="article" id="article" placeholder="文章内容">
                <%=editor_blog.getArticle()==null?"":editor_blog.getArticle()%></textarea>
            <div id="article_buttom">
                <input type="submit" value="发表" class="form_bt" />
                <input type="reset" value="重置" class="form_bt" />
            </div>
        </form>
    </div>
</div>

