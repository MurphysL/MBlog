<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/11
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="yq_register">
    <div id="yq_register_info">
        <img class="cancel" src="../../img/cancel.png" onclick="back()">
        <form name="yq_register_form" method="post" action="../../servlet/RegisterServlet" onsubmit="return register_check()">
            <input class="form_input" type="text" name="username" placeholder="用 户 名"><br>
            <input class="form_input" type="password" name="password" placeholder="密    码(字母或数字)"><br>
            <input class="form_input" type="password" name="password2" placeholder="重复密码"><br>
            <input class="form_input" type="email" name="email" placeholder="E-mail"><br>
            <input type="radio" name="sex" value="男" checked="true" placeholder="性    别">男&nbsp;
            <input type="radio" name="sex" value="女">女<br>
            <input class = "form_bt" type="submit" name="submit" value="确认">
            <input class = "form_bt" type="reset" name="reset" value="重置">
        </form>
    </div>
</div>
