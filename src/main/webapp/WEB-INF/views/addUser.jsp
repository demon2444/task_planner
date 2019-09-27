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
<div class="container">

    <header>Task Planner</header>
    <div id="day"></div><p id="time"></p>


</div>
<div class="container">
    <div class="card-body">

        <form:form method="post" modelAttribute="user">
        <div class="form-row">
            <div class="form-group col-md-6">

                <label for="username">Nazwa Użytkownika</label>
                <form:input path="username" placeholder="Username" class="form-control" id="username"/>


            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword">Hasło</label>
                <form:input path="password" placeholder="Password" type="password" class="form-control" id="inputPassword"/>
            </div>
        </div>

            <div class="form-row">

                <div class="form-group col-md-6">
                    <label for="fistname">Imię</label>
                    <form:input path="firstName" id="fistname" placeholder="Imię" class="form-control" />

                </div>
                <div class="form-group col-md-6">
                    <label for="fistname">Nazwisko</label>
                    <form:input path="lastName" placeholder="Nazwisko" class="form-control"/>
                </div>
            </div>





        <div class="form-group">
            <label for="inputAddress">Email</label>
            <form:input path="email" id="inputAddress" placeholder="Email" class="form-control" />
            <form:hidden path="enabled"/>
        </div>





        <button type="submit" class="btn btn-primary">Zarejestruj</button>


        </form:form>


</div>
</div>




<script src="../../js/time.js"></script>
</body>
</html>
