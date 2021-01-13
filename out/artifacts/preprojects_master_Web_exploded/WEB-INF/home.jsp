<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: georg
  Date: 24.02.2020
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <title>PreProjectCrudApp</title>
    <style type="text/css">
        body{
            text-align: center;
        }
        table {
            margin-left: 15%;
            min-width: 70%;
            border: 1px solid #CCC;
            border-collapse: collapse;
        }
        table tr{line-height: 30px;}
        table tr th { background: #000033; color: #FFF;}
        table tr td { border:1px solid #CCC; margin: 5px;}
        input[type=text], input[type=email], input[type=tel]{
            min-width: 60%;
        }
        input[type=submit], a{
            background: green;
            padding: 5px;
            margin: 5px;
            color: #FFF;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>


<body>

<h1>Servlet, JSP and JDBC CRUD Operations</h1>

<c:url value="/musician/register" var="registerUrl" />
<form action="${'${'}registerUrl}" method="post">

    <table>
        <c:if test="${'${'}musician.id ne null}">
            <tr>
                <td>Musician ID:</td>
                <td><input type="text" name="id" value="${'${'}musician.id}" readonly="readonly"></td>
            </tr>
        </c:if>


        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${'${'}musician.name}" required></td>
        </tr>
        <tr>
            <td>Song:</td>
            <td><input type="text" name="musician" value="${'${'}musician.song}" required></td>
        </tr>
        <tr>
            <td>Album:</td>
            <td><input type="album" name="album" value="${'${'}musician.album}" required></td>
        </tr>
        <tr>

        <c:if test="${'${'}musician.id ne null}">
            <tr>
                <td colspan="2"><input type="submit" value="Update"></td>
            </tr>
        </c:if>


        <c:if test="${'${'}musician.id eq null}">
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </c:if>


    </table>
</form>

<br>
<h1>List of Musicians</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Song</th>
        <th>Album</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${'${'}musicianList}" var="musician">
        <tr>
            <td>${'${'}musician.id}</td>
            <td>${'${'}musician.name}</td>
            <td>${'${'}musician.song}</td>
            <td>${'${'}musician.album}</td>

            <td>
                <form action="<c:url value="/musician/update"/>" method="post">
                    <input type="hidden" name="musId" value="${'${'}musician.id}">
                    <input type="submit" value="Update">
                </form>
            <td>
                <form action="<c:url value="/musician/delete"/>" method="post">
                    <input type="hidden" name="musId" value="${'${'}musician.id}">
                    <input style="background: #F00;" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>


</table>

</body>

</html>
