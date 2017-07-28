<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
</head>
<body>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <div class="containerTable">
        <div class="row tableHeader">
            <div class="col-md-2 col-xs-2 headerCol">Name</div>
            <div class="col-md-2 col-xs-2 headerCol">Adress</div>
            <div class="col-md-2 col-xs-2 headerCol">Average Price</div>
            <div class="col-md-2 col-xs-2 headerCol">Alelo</div>
            <div class="col-md-2 col-xs-2 headerCol">Image</div>
            <div class="col-md-2 col-xs-2 headerCol">Controls</div>
        </div>
        <div class="row tableBody">

        <c:forEach var="establishment" items="${establishments}">
            <div class="row tableLine" id="${establishment.id}">
                <div class="col-md-2 col-xs-2 bodyCol">${establishment.name}</div>
                <div class="col-md-2 col-xs-2 bodyCol">${establishment.address}</div>
                <div class="col-md-2 col-xs-2 bodyCol">${establishment.averagePrice}</div>
                <div class="col-md-2 col-xs-2 bodyCol">${establishment.aleloAccepted}</div>
                <div class="col-md-2 col-xs-2 bodyCol">${establishment.image}</div>
                <div class="col-md-1 col-xs-1 bodyCol"><input type="button" value="Edit" onclick="location.href='edit/${establishment.id}'"></div>
                <div class="col-md-1 col-xs-1 bodyCol"><input type="button" value="Remove" onclick="location.href='remove/${establishment.id}'"></div>
            </div>
        </c:forEach>

        </div>
    </div>
    <br>
    <input type="button" value="Add" onclick="location.href='add'">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>
    </script>
</body>
</html>