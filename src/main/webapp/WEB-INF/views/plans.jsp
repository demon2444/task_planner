<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 21.09.2019
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>

    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">

    <title>Show my Plans</title>
</head>
<body>
<%@include file="fragments/header.jspf"%>


<table>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
    <th>Start Task</th>
    <th>End Task</th>
    <c:forEach items="${plans}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.description}</td>
            <td>${u.timeStartView}</td>
            <td>${u.timeStopView}</td>

        </tr>

    </c:forEach>
</table>
<br><br><br>
<div class="container">

    <button type="button" class="btn btn-success" id="show">Show Time</button>
</div>

<!-- js -->
<script src="/js/app.js"></script>
<script src="../../js/time.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>




</body>
</html>
