<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Form</title>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" type="text/css">
<link rel="stylesheet" href="/resources/css/form.css">
<link rel="stylesheet" href="/resources/css/theme.css">
<link rel="stylesheet" href="/resources/css/user_register.css">

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
        <button id="cancel" type="button" value="cancel">Cancel</button>
    </div>
    <form:input path="id" value="${user.id}"/>
</form:form>
<div class="col-md-2 col-xs-0"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="/resources/js/user_register.js"></script>
</body>
</html>