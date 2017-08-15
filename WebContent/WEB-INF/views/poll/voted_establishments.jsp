<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Poll List</title>
    </head>
    <body>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" type="text/css">
        <link rel="stylesheet" href="/resources/css/list.css">
        <link rel="stylesheet" href="/resources/css/theme.css">

        <div class="title">Poll List</div>
        <hr/>
        <div class="col-md-2 col-xs-0"></div>
        <div class="col-md-8 col-xs-8 containerTable establishments">
            <div class="search">Search: <input id="search"></div>
            <div class="row tableBody">

            <c:forEach var="establishment" items="${establishments}">
                <div class="row tableLine" id="${establishment.id}">
                    <div class="info">
                        <div class="col-md-7 col-xs-7 text">
                            <div class="name">${establishment.name} - Votes: ${establishment.countOfVotes}</div>
                            <br>
                            <div class="address">${establishment.address}</div>
                            <br>
                            <div class="payment">
                                <img class="coin" src="/resources/img/money.png" alt=""> ${establishment.averagePrice}
                                <c:if test="${establishment.aleloAccepted}">
                                    <img class="aleloLogo" src="/resources/img/alelo.png">
                                </c:if>
                            </div>
                        </div>
                        <div class="col-md-5 col-xs-5 logo">
                            <img
                                <c:choose>
                                <c:when test="${not empty establishment.image}">
                                     src="${establishment.image}"
                                </c:when>
                                <c:otherwise>
                                     src="/resources/img/noimage.png"
                                </c:otherwise>
                                </c:choose>
                            >
                        </div>
                    </div><br>
                    <div class="establishmentMap">
                        <iframe
                                frameborder="0"
                                src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyDGH2o_Mc3-rDbjqCDIXmUIG93qNaVL3x0&origin=Avenida SAP, 188 - Cristo Rei, São Leopoldo - RS, 93022-718&destination=${establishment.address}"
                                allowfullscreen>
                        </iframe>
                    </div>
                    <div class="establishmentControls">
                        <c:if test="${poll.chosenEstablishment.id eq establishment.id}"><img class="flag upButton" src="/resources/img/flag.png"></c:if>
                        <img class="usersButton downButton" src="/resources/img/users.png" onclick="location.href='/poll/votedUsers/${poll.id}/${establishment.id}'">
                    </div>
                </div>
            </c:forEach>

            </div>
        </div>
        <div class="col-md-2 col-xs-0">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="/resources/js/jquery.quicksearch.js"></script>
        <script>
            $(function () {
                $(".search #search").quicksearch(".tableBody .tableLine");
            });
        </script>
    </body>
</html>