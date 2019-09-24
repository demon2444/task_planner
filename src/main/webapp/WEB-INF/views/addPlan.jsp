<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>



    <title>Dodaj Plan</title>
</head>
<body>

<%@ include file="fragments/header.jspf" %>

<div class="container">

    <header>Dodaj swój plan</header>

    <div class="card">

        <div class="card-body">
            <a href="/plan/planMatrix" class="btn btn-primary">Back</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">


<form:form method="post" modelAttribute="plan">
    <form:input path="name" placeholder="Nazwa Planu"/><br>
    <form:input path="description" placeholder="Opis planu"/><br>
    <form:input type="number" path="user.id" placeholder="User Id"/><br>
    <form:input type="date" path="dateStartView" placeholder="Start day"/>
    <form:input type="time" path="timeStartView" placeholder="Start time"/><br>
    <form:input type="date" path="dateStopView" placeholder="Stop day"/>
    <form:input type="time" path="timeStopView" placeholder="Stop time"/><br>


    <label>Ważne</label>
    <form:radiobutton path="important" value="true"/>Yes
    <form:radiobutton path="important" value="false"/>No<br>
    <label>Pilne</label>
    <form:radiobutton path="urgent" value="true"/>Yes
    <form:radiobutton path="urgent" value="false"/>No<br>
    <input type="submit" value="Dodaj">
</form:form>


</div>
</div>

</div>


</body>
</html>
