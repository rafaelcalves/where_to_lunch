<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="h" uri=""%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Establishment Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" type="text/css">
        <link rel="stylesheet" href="/resources/css/form.css">
        <link rel="stylesheet" href="/resources/css/theme.css">
        <%@include file="/resources/tag/template.tag"%>
    </head>

    <body>

        <div class="container">

            <form method="POST" action="/user/login" class="form-signin" modelAttribute="user">
                <h2 class="form-heading">Log in</h2>

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="email" type="text" class="form-control" placeholder="Email"
                           autofocus="true"/>
                    <input name="password" type="password" class="form-control" placeholder="Password"/>
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                    <h4 class="text-center"><a href="/user/add">Create an account</a></h4>
                </div>

            </form>

        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
