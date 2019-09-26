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

    <title>Logowanie</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>

<div class="container">

    <header>Task Planner</header>
    <div id="day"></div><p id="time"></p>


</div>
<div class="container">
    <div class="card mt-4">






<div class="card text-center">
<div class="card mt-4">

    <div class="card-body">
        <h5 class="card-title">Zaloguj się do serwisu</h5>

        <form:form method="post" modelAttribute="user">

            <form:input path="username" placeholder="Login"/>
            <p class="card-text"></p>
            <form:input path="password"  type="password" placeholder="Hasło"/>
            <p class="card-text"></p>
            <input type="submit" class="btn btn-primary" value="Zaloguj">
        </form:form>



    </div>
    <div class="card-footer text-muted">

    </div>
</div>



        </div></div></div>

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


<script src="../../js/time.js"></script>
</body>
</html>