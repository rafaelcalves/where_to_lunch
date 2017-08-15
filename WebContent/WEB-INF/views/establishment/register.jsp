<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:template>
    <jsp:attribute name="header">
        <link rel="stylesheet" href="/resources/css/form.css">
    </jsp:attribute>

    <jsp:attribute name="title">
        Establishment Form
    </jsp:attribute>

    <jsp:attribute name="footer">
        <script src="/resources/js/establishment_register.js"></script>
    </jsp:attribute>

    <jsp:body>

        <div class="title">Establishment Form</div>
        <hr/>
        <div class="col-md-2 col-xs-0"></div>
        <form:form modelAttribute="establishment" cssClass="col-md-8 col-xs-12" servletRelativeAction="/establishment/register" method="POST">
            Name: <form:errors path="name"/><br/>
            <form:input path="name" value="${establishment.name}"/><br/>
            Adress (Street, Number, City, State): <form:errors path="address"/><br/>
            <form:input path="address" value="${establishment.address}"/><br/>
            Average price: <form:errors path="averagePrice"/><br/>
            <form:input path="averagePrice" type="number" step="0.01" value="${establishment.averagePrice}"/>
            <form:checkbox path="aleloAccepted" value="${establishment.aleloAccepted}"/>
            <img class="aleloLogo <c:if test="${establishment.aleloAccepted}">checked</c:if>" src="/resources/img/alelo.png"><br/>
            Image(URL): <form:errors path="image"/><br/>
            <form:input path="image" value="${establishment.image}"/><br/>
            <div class="controls">
                <form:button id="submit">Save</form:button>
                <button id="cancel" onclick="location.href='/'" type="button" value="cancel">Cancel</button>
            </div>
            <form:input path="id" value="${establishment.id}"/>
        </form:form>
        <div class="col-md-2 col-xs-0"></div>
    </jsp:body>
</t:template>