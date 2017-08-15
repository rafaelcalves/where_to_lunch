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
        Poll List
    </jsp:attribute>
    <jsp:body>
        <img class="addButton" src="/resources/img/add.png" onclick="location.href='/poll/add'">
        <div class="title">Poll List</div>
        <hr/>
        <div class="col-md-2 col-xs-0"></div>
        <div class="col-md-8 col-xs-8 containerTable establishments">
            <div class="row tableBody">

                <c:forEach var="poll" items="${polls}">
                    <div class="row tableLine" id="${poll.id}">
                        <div class="info">
                            <div class="col-md-7 col-xs-7 text">
                                <div class="name">${poll.description} - ${poll.endingDate}</div>
                                <br>
                                <div class="address">${poll.chosenEstablishment.name}</div>
                                <br>
                            </div>
                            <div class="col-md-5 col-xs-5 logo">
                                <img
                                <c:choose>
                                    <c:when test="${empty poll.chosenEstablishment}">
                                            src="/resources/img/flag.png"
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${not empty poll.chosenEstablishment.image}">
                                                    src="${poll.chosenEstablishment.image}"
                                            </c:when>
                                            <c:otherwise>
                                                    src="/resources/img/noimage.png"
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                                <c:if test="${empty poll.chosenEstablishment}">
                                        onclick="location.href='finish/${poll.id}'"
                                </c:if>
                                >
                            </div>
                        </div><br>
                        <div class="establishmentMap">
                            <c:if test="${not empty poll.chosenEstablishment}">
                                <iframe
                                        frameborder="0"
                                        src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyDGH2o_Mc3-rDbjqCDIXmUIG93qNaVL3x0&origin=Avenida SAP, 188 - Cristo Rei, São Leopoldo - RS, 93022-718&destination=${poll.chosenEstablishment.address}"
                                        allowfullscreen>
                                </iframe>
                            </c:if>
                        </div>
                        <div class="controls">
                            <c:if test="${empty poll.chosenEstablishment}">
                                <img class="listButton upButton" src="/resources/img/list.png" onclick="location.href='list/${poll.id}'">
                            </c:if>
                            <img class="usersButton downButton" src="/resources/img/users.png" onclick="location.href='/poll/votedEstablishments/${poll.id}'">

                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
        <div class="col-md-2 col-xs-0"></div>
    </jsp:body>
</t:template>