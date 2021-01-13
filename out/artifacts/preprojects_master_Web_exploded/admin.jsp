<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>User Application</title>
</head>


<body>

<center>
    <h1>Users</h1>
    <h2>
        <a href="/admin/list">List All Users</a>
    </h2>
</center>


<div align="center">

    <table border="1" cellpadding="5">


        <caption><h2>List of Users</h2></caption>

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        db_example

        <c:forEach var="user" items="${users}">
            <tr>

                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td>
                    <a href= "/admin/update?id=<c:out value='${user.id}' />">Edit</a>
                    <a href="/admin/delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>

            </tr>
        </c:forEach>


        </table>

    </form>

    <a href = "/logout">Logout</a>

</div>


</body>
</html>