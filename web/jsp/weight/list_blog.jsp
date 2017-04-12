<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/11
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="bean.Blog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="blogs" class="bean.Blogs"/>

<div id="yq_content">
    <div id="yq_inner">
        <div id="yq_frg1">
            <img src="../../img/pic1.jpg" id="f_img1">
            <a id="f_title1" class="title" href="../jsp/view/article.jsp">从前有座山</a>
            <p id="f_des1" class="des">Lorem ipsum dolor sit amet...</p>
        </div>
        <div id="yq_frg2">
            <img src="../../img/pic2.jpg" id="f_img2">
            <a id="f_title2" class="title" href="../jsp/view/article.jsp">山里有座庙</a>
            <p id="f_des2" class="des">consectetur adipisicing elit...</p>
        </div>
        <div id="yq_frg3">
            <img src="../../img/pic3.jpg" id="f_img3">
            <a id="f_title3" class="title" href="../jsp/view/article.jsp">庙里有个老和尚</a>
            <p id="f_des3" class="des">sed do eiusmod tempor incididunt ut labore et...</p>
        </div>
        <div id="yq_frg4">
            <img src="../../img/pic4.jpg" id="f_img4">
            <a id="f_title4" class="title" href="../jsp/view/article.jsp">是个哑巴</a>
            <p id="f_des4" class="des">Ut enim ad minim veniam...</p>
        </div>
    </div>
</div>
