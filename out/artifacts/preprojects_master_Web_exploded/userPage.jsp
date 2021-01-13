<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users Application</title>
</head>

<body>


<center>
    <h1>Users management</h1>
    <h2>
        <a href="/register">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Users</a>
    </h2>
</center>



<div align="center">



            <form action="/register" method="POST">

                <table border="1" cellpadding="5">


                <caption>
                    <h2>
                            Add New User
                    </h2>
                </caption>



                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="${user.name}"
                        />
                    </td>
                </tr>



                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="text" name="password" size="45"
                               value="${user.password}"
                        />
                    </td>
                </tr>



                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="${user.email}"
                        />
                    </td>
                </tr>


                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />

                        <a href="${pageContext.request.contextPath}/list">Cancel</a>
                    </td>
                </tr>


            </table>

        </form>

</div>


</body>
</html>