<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/11
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="yq_login">
    <div id="yq_login_info">
        <img class="cancel" src="../../img/cancel.png" onclick="back()">
        <form name="yq_form" method="post" action="../../servlet/LoginServlet" onsubmit="return check()">
            <input class="form_input" type="email" name="email" placeholder="E-mail"><br>
            <input class="form_input" type="password" name="password" placeholder="密    码(字母或数字)"><br>
            <input class = "form_bt" type="submit" name="submit" value="确认">
            <input class = "form_bt" type="reset" name="reset" value="重置">
        </form>
    </div>
</div>
