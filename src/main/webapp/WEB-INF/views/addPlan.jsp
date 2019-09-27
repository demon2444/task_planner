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
    <div id="day"></div>
    <p id="time"></p>

    <div class="card">

        <div class="card-body">
            <a href="/" class="btn btn-primary">Powrót</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">


            <form:form method="post" modelAttribute="plan">


                <div class="row">
                    <div class="col">
                        <form:input path="name" placeholder="Nazwa Planu" class="form-control"/>
                    </div>
                    <div class="col">
                        <form:textarea path="description" placeholder="Opis planu" cols="40" rows="3"/>
                        <form:hidden path="user.id" placeholder="User Id" class="form-control"/>
                    </div>
                    <div class="col">

                        <form:input type="date" path="dateStartView" placeholder="Start day" id="theDate"/>

                        <form:input type="time" path="timeStartView" placeholder="Start time" value="07:00"/>

                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <label>Ważne</label>
                        <form:radiobutton path="important" value="true"/>Tak
                        <form:radiobutton path="important" value="false"/>Nie
                    </div>
                    <div class="col">
                        <label>Pilne</label>
                        <form:radiobutton path="urgent" value="true"/>Tak
                        <form:radiobutton path="urgent" value="false"/>Nie
                    </div>
                    <div class="col">
                        <form:input type="date" path="dateStopView" placeholder="Stop day" id="now"/>
                        <form:input type="time" path="timeStopView" placeholder="Stop time" value="08:00"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                    <input type="submit" value="Dodaj" class="btn btn-outline-info my-2 my-sm-0">
                    </form:form>
                    </div>
                </div>
                </div>









        </div>
    </div>

</div>
<script src="/js/app.js"></script>
<script src="../../js/time.js"></script
</body>
</html>
