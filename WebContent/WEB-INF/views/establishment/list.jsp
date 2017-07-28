<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <table border="1">
        <tr>
            <th>Name</th>
            <th>Adress</th>
            <th>Average Price</th>
            <th>Alelo</th>
            <th>Image</th>
        </tr>
        <c:forEach var="establishment" items="${establishments}">

            <tr id = "${establishment.id}">
                <td>${establishment.name}</td>
                <td>${establishment.address}</td>
                <td>${establishment.averagePrice}</td>
                <td>${establishment.aleloAccepted}</td>
                <td>${establishment.image}</td>
                <td><a href="edit/${establishment.id}">Edit</a></td>
                <td><a href="remove/${establishment.id}">Remove</a></td>
                <%--<td><button class="removeButton" value = "${establishment.id}">Remove</button></td>--%>
                <%--<td><button class="editButton" value = "${establishment.id}">Remove</button></td>--%>
            </tr>
        </c:forEach>
    </table>
    <br>
    <input type="button" value="Add" onclick="location.href='add'">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>
    </script>
</body>
</html>