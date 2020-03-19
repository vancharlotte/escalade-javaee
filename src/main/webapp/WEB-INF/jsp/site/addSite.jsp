<%--
  Created by IntelliJ IDEA.
  User: vanhu
  Date: 11/03/2020
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>add site</title>
    <style>
        .error{color:red}
    </style>
</head>

<body>
<h2>Site :</h2>
<form:form method = "POST" action = "/escalade/site" modelAttribute="site" >

    <table>

        <tr>
            <td><form:label path = "name">Username :</form:label></td>
            <td><form:input path ="name" maxlength="25" required="required" value="name"/>
                <form:errors path="name" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path ="location">Location :</form:label></td>
            <td><form:input path ="location"  required="location"/>
                <form:errors path="location" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path ="description">Description :</form:label></td>
            <td><form:input path ="description" minlength="20" required="description"/>
                <form:errors path="description" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>



</body>

</html>