<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>



    <title>Dodaj Plan</title>
</head>
<body>

<%@ include file="fragments/header.jspf" %>

<div class="container">

    <header>Plan na dziś</header>
    <div id="time"></div><div id="day"></div>
    <div class="card">

        <div class="card-body">
            <a href="/plan/planMatrix" class="btn btn-primary">Back</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">


            <form method="get" action="/plan/dayF">
                <input type="date" name="dayStart"  id="today" placeholder="Wybierz dzień"/>
                <input type="time" name="hourStart" value="07:00" placeholder="Wybierz godzinę"/>



                <input type="submit" class="btn btn-dark" value="Sprawdź">
            </form>


        </div>
    </div>

</div>
<script src="/js/app.js"></script>
<script src="../../js/time.js"></script>

</body>
</html>
