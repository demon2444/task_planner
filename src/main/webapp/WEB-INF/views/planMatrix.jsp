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
    <div id="day"></div><p id="time"></p>


</div>
<div class="container">



            <table class="table table-hover">
                <thead>
                <tr class="row">
                    <th scope="col" class="table-danger col-md-6">Pilne i ważne</th>
                    <th scope="col" class="table-info col-md-6">Niepilne ale ważne</th>
                </tr>
                </thead>
                <tbody>
                <tr class="row">
                    <td class="table-danger col-md-6">
                        <c:forEach items="${iu}" var="u">

                            ${u.name}
                            ${u.description}
                            ${u.timeStartView}
                            ${u.timeStop}<br><br>


                        </c:forEach>
                    </td>


                    <td class="table-info col-md-6"><c:forEach items="${iNu}" var="u">

                        ${u.name}
                        ${u.description}
                        ${u.timeStartView}
                        ${u.timeStop}<br><br>


                    </c:forEach>
                    </td>
                </tr>


                <tr class="row">
                    <td class="table-warning col-md-6">
                        <c:forEach items="${nIu}" var="u">

                            ${u.name}
                            ${u.description}
                            ${u.timeStartView}
                            ${u.timeStop}<br><br>


                        </c:forEach>
                    </td>


                    <td class="table-secondary col-md-6"><c:forEach items="${nInU}" var="u">

                        ${u.name}
                        ${u.description}
                        ${u.timeStartView}
                        ${u.timeStopView}<br><br>

                    </c:forEach></td>
                </tr>


                </tbody>
                <thead>
                <tr class="row">
                    <th scope="col" class="table-warning col-md-6">Pilne i nieważne</th>
                    <th scope="col" class="table-secondary col-md-6">Niepilne i nieważne</th>
                </tr>
                </thead>
            </table>
        </div>
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