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

    <div class="card">

        <div class="card-body">
            <a href="/plan/planMatrix" class="btn btn-primary">Back</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">


            <form method="post" action="/plan/day">
                <input type="date" name="dayStart"  placeholder="Wybierz dzień"/>
                <input type="time" name="hourStart" placeholder="Wybierz dzień"/>



                <input type="submit" value="Sprawdź">
            </form>


        </div>
    </div>

</div>


</body>
</html>
