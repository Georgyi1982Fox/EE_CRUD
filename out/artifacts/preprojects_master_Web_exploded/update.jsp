
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Page</title>
</head>
<body>

<div align="center">



        <form action="update.jsp" method="post">
            <table border="1" cellpadding="5">


                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"  value="${userOne.name}"
                        />
                    </td>
                </tr>



                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="text" name="password" size="45"
                               value="${userOne.password}"
                        />
                    </td>
                </tr>



                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="${userOne.email}"
                        />
                    </td>
                </tr>


                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="update" />

                        <a href="${pageContext.request.contextPath}/admin">Cancel</a>
                    </td>
                </tr>

            </table>


</form>
<a href="/admin">List</a>

</div>

</body>

</html>
