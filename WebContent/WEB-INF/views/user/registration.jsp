<%--
  Created by IntelliJ IDEA.
  User: I863256
  Date: 02/08/2017
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Spring Security Example </title>
    </head>
    <body>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" type="text/css">
        <link rel="stylesheet" href="/resources/css/theme.css">

        <h1 th:text="#{label.form.title}">form</h1>
        <form action="/" th:object="${user}" method="POST" enctype="utf8">
            <div>
                <label th:text="#{label.user.firstName}">first</label>
                <input th:field="*{firstName}"/>
                <p th:each="error: ${#fields.errors('firstName')}"
                   th:text="${error}">Validation error</p>
            </div>
            <div>
                <label th:text="#{label.user.lastName}">last</label>
                <input th:field="*{lastName}"/>
                <p th:each="error : ${#fields.errors('lastName')}"
                   th:text="${error}">Validation error</p>
            </div>
            <div>
                <label th:text="#{label.user.email}">email</label>
                <input type="email" th:field="*{email}"/>
                <p th:each="error : ${#fields.errors('email')}"
                   th:text="${error}">Validation error</p>
            </div>
            <div>
                <label th:text="#{label.user.password}">password</label>
                <input type="password" th:field="*{password}"/>
                <p th:each="error : ${#fields.errors('password')}"
                   th:text="${error}">Validation error</p>
            </div>
            <div>
                <label th:text="#{label.user.confirmPass}">confirm</label>
                <input type="password" th:field="*{matchingPassword}"/>
            </div>
            <button type="submit" th:text="#{label.form.submit}">submit</button>
        </form>

        <a th:href="@{/user/login.html}" th:text="#{label.form.loginLink}">login</a>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>