<%--
  Created by IntelliJ IDEA.
  User: georg
  Date: 24.03.2020
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserInfo</title>
</head>
<body>

<div align="center">
<h1>Hello "${userLogin}"</h1>
    <h2>your login is "${userLogin}"</h2>
    <h2>your password is "${userPassword}"</h2>
    <a href="${pageContext.request.contextPath}/">Home Page</a>
</div>

</body>
</html>
