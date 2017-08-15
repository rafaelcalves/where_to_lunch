<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: I863256
  Date: 24/07/2017
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
  </head>
  <body>
    <input type="button" value="Add Establishment" onclick="location.href='establishment/add'">
    <input type="button" value="List Establishments" onclick="location.href='establishment/'">
    <br>
    <br>
    <input type="button" value="Add Poll" onclick="location.href='poll/add'">
    <input type="button" value="Poll History" onclick="location.href='poll/history'">
    <br>
    <br>
    <c:if test="${empty userName}">
      <input type="button" value="Sign Up" onclick="location.href='user/add'">
      <input type="button" value="Login" onclick="location.href='user/login'">
    </c:if>
    <c:if test="${not empty userName}">
      ${userName}
    </c:if>
  </body>
</html>
