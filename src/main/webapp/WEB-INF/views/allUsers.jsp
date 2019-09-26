<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<script src="../../js/time.js"></script>
</body>
</html>
