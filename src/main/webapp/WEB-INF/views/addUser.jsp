<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 21.09.2019
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Adding User</title>
</head>
<body>
<%@ include file="fragments/header.jspf" %>


<div id="day"></div><p id="time"></p>

    <form:form method="post" modelAttribute="user">
        <form:input path="firstName" placeholder="First name"/><br>
        <form:input path="lastName" placeholder="Last name"/><br>
        <form:input path="password" placeholder="Password"/><br>
        <input type="submit" value="Send">
    </form:form>
<script src="../../js/time.js"></script>
</body>
</html>
