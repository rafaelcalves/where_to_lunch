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
        User Form
    </jsp:attribute>

    <jsp:attribute name="footer">
        <script src="/resources/js/user_register.js"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="title">User Form</div>
        <hr/>
        <div class="col-md-2 col-xs-0"></div>
        <form:form modelAttribute="user" cssClass="col-md-8 col-xs-12" servletRelativeAction="/user/register" method="POST">
            First Name: <form:errors path="firstName"/><br/>
            <form:input path="firstName" value="${user.firstName}"/><br/>
            Last Name: <form:errors path="lastName"/><br/>
            <form:input path="lastName" value="${user.lastName}"/><br/>
            Email: <form:errors path="email"/><br/>
            <form:input path="email" value="${user.email}"/><br/>
            Date of Birthday:<form:errors path="dob"/><br/>
            <form:input path="dob" type="datetime-local" value="${user.dob}"/><br/>
            Password: <form:errors path="password"/> <span class="password"></span><br/>
            <form:input path="password" type="password" class="password" value="${user.password}"/><br/>
            Confirm Password:<br/>
            <form:input path="confirmPassword" type="password" class="password" value="${user.confirmPassword}"/><br/>
            <div class="controls">
                <form:button id="submit" disabled="true">Save</form:button>
                <button id="cancel" onclick="location.href='/'" type="button" value="cancel">Cancel</button>
            </div>
            <form:input path="id" value="${user.id}"/>
        </form:form>
        <div class="col-md-2 col-xs-0"></div>
    </jsp:body>
</t:template>