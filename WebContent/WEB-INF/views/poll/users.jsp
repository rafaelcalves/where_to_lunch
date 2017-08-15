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
        Voted Users
    </jsp:attribute>
    <jsp:body>
        <div class="title">Voted Users</div>
        <hr/>
        <div class="col-md-2 col-xs-0"></div>
        <div class="col-md-8 col-xs-8 containerTable establishments">
            <div class="row tableBody">

                <c:forEach var="user" items="${users}">
                    <div class="row tableLine" id="${user.id}">
                        <div class="info">
                            <div class="col-md-7 col-xs-7 text">
                                <div class="firstName">${user.firstName}</div>
                                <br>
                                <div class="lastName">${user.lastName}</div>
                                <br>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-2 col-xs-0"></div>
    </jsp:body>
</t:template>