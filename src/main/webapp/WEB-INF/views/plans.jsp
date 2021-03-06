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
<%@include file="fragments/header.jspf" %>


<div class="container">

    <header>Task Planner</header>
    <div id="day"></div>
    <p id="time"></p>


</div>
<div class="container">
    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Nazwa zadania</th>
                    <th scope="col">Opis zadania</th>
                    <th scope="col">Data rozpoczęcia</th>
                    <th scope="col">Godzina rozpoczęcia</th>
                    <th scope="col">Data zakończenia</th>
                    <th scope="col">Godzina zakończenia</th>
                    <th scope="col">Edytuj</th>
                    <th scope="col">Zakończ</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${plans}" var="u">


                    <c:choose>
                        <c:when test="${u.urgent && u.important}">
                            <tr class="table-danger">
                        </c:when>
                        <c:when test="${!u.urgent && u.important}">
                            <tr class="table-info">
                        </c:when>
                        <c:when test="${u.urgent && !u.important}">
                            <tr class="table-warning">
                        </c:when>

                        <c:otherwise>
                            <tr class="bg-dark">
                        </c:otherwise>
                    </c:choose>

                    <td>${u.name}</td>
                    <td>${u.description}</td>
                    <td>${u.dateStartView}</td>
                    <td>${u.timeStartView}</td>
                    <td>${u.dateStopView}</td>
                    <td>${u.timeStopView}</td>
                    <td>
                        <a href="/plan/update/${u.id}" class="btn btn-info">Edytuj</a></td>
                    <td>
                        <a href="/plan/done/${u.id}/${timeSes}" class="btn btn-success">Zrobione</a>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</div>
</div>


<div class="container">
    <table border="1">

        <c:forEach items="${time}" var="t">
            <tr>
                <td>${t.days}</td>
                <td>${t.hours}</td>
                <td>${t.minutes}</td>
                <td>${t.seconds}</td>
            </tr>
        </c:forEach>

    </table>

</div>
</div>
</div>

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