<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:template>
    <jsp:attribute name="header">
        <link rel="stylesheet" href="/resources/css/form.css">
    </jsp:attribute>

    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:body>
        <div class="title">Login</div>
        <hr/>
        <div class="col-md-2 col-xs-0"></div>
        <div class="col-md-8 col-xs-12">
             <form method="POST" action="/user/login" class="form-signin" modelAttribute="user">
                 <div class="${error != null ? 'has-error' : ''}">
                     <span>${message}</span>
                     <input name="email" type="text" placeholder="Email"
                            autofocus="true"/>
                     <input name="password" type="password" placeholder="Password"/>
                     <span>${error}</span>
                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                     <br>
                     <button type="submit">Log In</button>
                 </div>
             </form>
        </div>
        <div class="col-md-2 col-xs-0"></div>
    </jsp:body>
</t:template>
