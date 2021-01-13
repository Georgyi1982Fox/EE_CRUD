<%--
  Created by IntelliJ IDEA.
  User: georg
  Date: 26.03.2020
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>User Registration Page</title>
    </head>

    <body>


     <div align="center">
         <form action="/register" method="POST">

            <caption>
                <h2>
                    Add New User
                </h2>
            </caption>

             <p><b>Name:</b><br>
                 <input type="text" name="name" size="30"></p>
             <p><b>Password: </b><br>
                 <input type="password" name="password" size="30"></p>
             <p><b>Email:</b><br>
                 <input type="text" name="email" size="30"></p>
             <p> <input type="submit" value="Save"
                   />

                 <a href="${pageContext.request.contextPath}/webapp">Home Page</a>

    </form>

</div>


</body>

