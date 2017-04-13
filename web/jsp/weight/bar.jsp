<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/13
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer id="bar">
    <div>
        <%=request.getSession().getAttribute("bar")%>
    </div>
</footer>
