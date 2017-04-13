<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/13
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="main">
    <div class="inner">
        <form action="../../servlet/CommitArticleServlet" method="post">
            <input type="text" name="title" id="title" placeholder="文章标题">
            <textarea name="article" id="article" placeholder="文章内容"></textarea>
            <div id="article_buttom">
                <input type="submit" value="发表" class="form_bt" />
                <input type="reset" value="重置" class="form_bt" />
            </div>
        </form>
    </div>
</div>
