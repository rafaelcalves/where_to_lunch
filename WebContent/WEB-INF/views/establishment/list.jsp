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
    <link rel="stylesheet" type="text/css" href="/resources/css/jTinder.css">

    <%--<table border="1">--%>
        <%--<tr>--%>
            <%--<th>Name</th>--%>
            <%--<th>Adress</th>--%>
            <%--<th>Average Price</th>--%>
            <%--<th>Alelo</th>--%>
            <%--<th>Image</th>--%>
        <%--</tr>--%>

    <!-- start padding container -->
    <div class="wrap">
        <!-- start jtinder container -->
        <div id="tinderslide">
            <ul>
                <c:forEach var="establishment" items="${establishments}">
                    <li class="pane${establishment.id}">
                        <div class="img"></div>
                        <div>${establishment.name}</div>
                        <div>${establishment.address}</div>
                        <div>${establishment.averagePrice}</div>
                        <div>${establishment.aleloAccepted}</div>
                        <div>${establishment.image}</div>
                        <div class="like"></div>
                        <div class="dislike"></div>
                    </li>
                    <%--<tr id = "${establishment.id}">--%>
                        <%--<td>${establishment.name}</td>--%>
                        <%--<td>${establishment.address}</td>--%>
                        <%--<td>${establishment.averagePrice}</td>--%>
                        <%--<td>${establishment.aleloAccepted}</td>--%>
                        <%--<td>${establishment.image}</td>--%>
                        <%--<td><a href="edit/${establishment.id}">Edit</a></td>--%>
                        <%--<td><a href="remove/${establishment.id}">Remove</a></td>--%>
                        <%--&lt;%&ndash;<td><button class="removeButton" value = "${establishment.id}">Remove</button></td>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<td><button class="editButton" value = "${establishment.id}">Remove</button></td>&ndash;%&gt;--%>
                    <%--</tr>--%>
                </c:forEach>
            </ul>
        </div>
        <!-- end jtinder container -->
    </div>
    <%--</table>--%>
    <br>
    <input type="button" value="Add" onclick="location.href='add'">

    <br>
    <br>

    <!-- jTinder trigger by buttons  -->
    <div class="actions">
        <a href="#" class="dislike"><i></i></a>
        <a href="#" class="like"><i></i></a>
    </div>

    <!-- jTinder status text  -->
    <div id="status"></div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- jQuery lib -->
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <!-- transform2d lib -->
    <script type="text/javascript" src="/resources/js/jquery.transform2d.js"></script>
    <!-- jTinder lib -->
    <script type="text/javascript" src="/resources/js/jquery.jTinder.js"></script>
    <!-- jTinder initialization script -->
    <script type="text/javascript" src="/resources/js/main.js"></script>
    <script>
    </script>
</body>
</html>