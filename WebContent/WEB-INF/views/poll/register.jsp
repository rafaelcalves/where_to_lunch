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
        Poll Form
    </jsp:attribute>
    <jsp:body>
        <div class="title">Poll Form</div>
        <hr/>
        <div class="col-md-2 col-xs-0"></div>
        <form:form modelAttribute="poll" cssClass="col-md-8 col-xs-12" servletRelativeAction="/poll/register" method="POST">
            Description: <form:errors path="description"/><br/>
            <form:input path="description" value="${poll.description}"/><br/>
            Ending date:<form:errors path="endingDate"/><br/>
            <form:input path="endingDate" type="datetime-local" value="${poll.endingDate}"/><br/>
            <div class="controls">
                <form:button id="submit">Save</form:button>
                <button id="cancel" onclick="location.href='/'" type="button" value="cancel">Cancel</button>
            </div>
            <form:input path="id" value="${poll.id}"/>
        </form:form>
        <div class="col-md-2 col-xs-0"></div>
    </jsp:body>
</t:template>