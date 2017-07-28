<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
        <h1>Establishment form!</h1>
        <hr/>
        <form:form modelAttribute="establishment" servletRelativeAction="/establishment/register" method="POST">
            Name: <form:input path="name" value="${establishment.name}"/>
            <form:errors path="name"/><br/>
            Adress (Street, Number, City, State): <form:input path="address" value="${establishment.address}"/>
            <form:errors path="address"/><br/>
            Average price: <form:input path="averagePrice" type="number" step="0.01" value="${establishment.averagePrice}"/>
            <form:errors path="averagePrice"/><br/>
            Average price: <form:checkbox path="aleloAccepted" value="${establishment.aleloAccepted}"/><br/>
            Image(URL): <form:input path="image" value="${establishment.image}"/>
            <form:errors path="image"/><br/>
            <form:button>Save</form:button>
            <%--<form:input path="id" value="${establishment.id}" style="visibility:hidden; height:0; width:0; position:absolute"/>--%>
        </form:form>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>

        </script>
    </body>
</html>