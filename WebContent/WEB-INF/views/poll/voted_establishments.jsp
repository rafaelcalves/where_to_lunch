<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:template>
    <jsp:attribute name="header">
        <link rel="stylesheet" href="/resources/css/list.css">
        <link rel="stylesheet" href="/resources/css/theme.css">
    </jsp:attribute>

    <jsp:attribute name="title">
        Vote List
    </jsp:attribute>

    <jsp:attribute name="footer">
        <script src="/resources/js/voted_search.js"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="title">Poll List</div>
        <hr/>
        <div class="col-md-2 col-xs-0"></div>
        <div class="col-md-8 col-xs-8 containerTable establishments">
            <div class="searchDiv">
                <input placeholder="Search...">
                <img class="search" src="/resources/img/search.png">
                <img class="clear" src="/resources/img/clear.png">
            </div>
            <div class="row tableBody" pollId="${poll.id}">

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
        <div class="col-md-2 col-xs-0"></div>
    </jsp:body>
</t:template>