<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 20.09.2019
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="/css/style.css" rel="stylesheet">

    <title>Task Planner</title>
</head>
<body>
<%@ include file="fragments/header.jspf" %>

<div class="container">

    <header>Know How czyli po krótce z czym to się je</header>
    <div id="time"></div>
    <p id="day"></p>


    <div class="card" style="width: 70rem;">
        <div class="card-header">MACIERZ EISENHOWERA

        </div>
        <ul class="list-group list-group-flush">

            <li class="list-group-item">

                Jest to koncepcja zarządzania czasem, występująca również pod nazwą „kwadratu/siatki/systemu/pola
                Eisenhowera” lub „Matrycy priorytetów”
                została opracowana na podstawie sposobu planowania zadań i zarządzaniu nimi przez trzydziestego
                czwartego prezydenta Stanów Zjednoczonych –
                Dwighta Eisenhowera

            </li>
            <li class="card-header">
                JAK ZARZĄDZAĆ ZADANIAMI PRZY POMOCY MACIERZY EISENHOWERA?
            </li>
            <li class="list-group-item">Koncepcja ta zakłada kategoryzację ważności i priorytetowości zadań do
                wykonania. Najczęściej przedstawiana jest
                jako kwadrat podzielony na
                cztery ćwiartki, każda określająca inną rangę spraw, które w niej umieścimy. Aby efektywnie używać tego
                sposobu,
                musimy jasno określić swoją
                listę priorytetów; mogą to być zarówno cele zawodowe, jak i prywatne. Na etapie klasyfikacji zadań może
                pojawić
                się wiele błędów, dlatego ta
                metoda, choć prosta i skuteczna, nie spełni swoich zadań, gdy będziemy się nią niewłaściwie posługiwać

            </li>
            <li class="card-header">
                DO CZEGO SŁUŻĄ POSZCZEGÓLNE OBSZARY MATRYCY?
            </li>
            <li class="list-group-item">
                Ćwiartka „I” – rzeczy ważne i pilne; są to zadania, które muszą zostać zrealizowane jak najszybciej.
                Często
                to sprawy, mające ściśle określony
                limit czasowy, nagłe sytuacje, które wymagają natychmiastowego rozwiązania oraz rzeczy, które powinny
                być
                rozwiązane już jakiś czas temu w przeszłości.

            </li>
            <li class="list-group-item">

                Ćwiartka „II” – rzeczy ważne i niepilne; tutaj znajdują się zadania, których realizacja nie musi zostać
                ukończona w jak najszybszym czasie, często
                związane z samorozwojem. Możemy „rozłożyć” ją na kilka dni, tygodni lub miesięcy, w zależności od tego,
                ile czasu konkretnie wymaga dana rzecz.

            </li>
            <li class="list-group-item">

                Ćwiartka „III” – rzeczy nieważne i pilne; są to sprawy, które należy szybko rozwiązać, ale nie mają
                dużej
                rangi ważności; można wobec tego oddelegować je do realizacji dla innej osoby.

            </li>
            <li class="list-group-item">

                Ćwiartka „IV” – rzeczy nieważne i niepilne; zadania, które tak naprawdę nie powinny zajmować naszej
                uwagi,
                należy ograniczyć ich udział w naszym codziennym życiu.
            </li>

            <li class="card-header">
                DO CZEGO SŁUŻY PODZIAŁ MATRYCY NA WAŻNE I PILNE?
            </li>
            <li class="list-group-item">

                WAŻNE – zadania, które są najważniejsze, wymagają też dłuższego czasu realizacji. Nie są to „pożary”,
                które
                należy jak najszybciej ugasić i które
                w macierzy mają rangę spraw pilnych. Rzeczy ważne, to rzeczy, na których realizacji powinno nam
                najbardziej
                zależeć, ponieważ nie są to
                jednorazowe zadania, które należy szybko i natychmiastowo wykonać, ale rzeczy determinujące wartość
                naszego
                życia

            </li>
            <li class="list-group-item">

                PILNE – zadania, które wymagają natychmiastowej uwagi i realizacji. Powinniśmy szybko się nimi zająć, by
                móc
                większość swojego skupienia i
                zaangażowania przeznaczyć sprawom ważnym. Dwigt Eisenhower podjął próbę rozróżnienia tych dwóch pojęć,
                mówiąc:
                „To, co ważne, rzadko jest pilne, a to, co pilne, rzadko jest ważne”.

            </li>



        </ul>
    </div>



        </div>



    </div>
</div>




<!-- js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="js/app.js"></script>
<script src="../../js/time.js"></script>
</body>
</html>
