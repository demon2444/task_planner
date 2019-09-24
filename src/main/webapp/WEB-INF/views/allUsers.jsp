<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 21.09.2019
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>All Users</title>

</head>
<body>

<%@ include file="fragments/header.jspf" %>

<table>
    <th>Id</th>
    <th>Firstname</th>
    <th>LastName</th>
    <th>Password</th>
    <c:forEach items="${users}" var="u">
    <tr>
        <td>${u.id}</td>
        <td>${u.firstName}</td>
        <td>${u.lastName}</td>
        <td>${u.password}</td>

    </tr>

    </c:forEach>
</table>
</body>
</html>
