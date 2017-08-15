<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:template>
    <jsp:attribute name="header">
        <link rel="stylesheet" href="/resources/css/form.css">
    </jsp:attribute>

    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:body>
         <div class="container">

             <form method="POST" action="/user/login" class="form-signin" modelAttribute="user">
                 <h2 class="form-heading">Log in</h2>

                 <div class="${error != null ? 'has-error' : ''}">
                     <span>${message}</span>
                     <input name="email" type="text" placeholder="Email"
                            autofocus="true"/>
                     <input name="password" type="password" placeholder="Password"/>
                     <span>${error}</span>
                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                     <button type="submit">Log In</button>
                 </div>

             </form>

         </div>
    </jsp:body>
</t:template>
