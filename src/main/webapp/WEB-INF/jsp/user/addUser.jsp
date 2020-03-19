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
    <title>add user</title>
    <style>
        .error{color:red}
    </style>
</head>

<body>
<h2>Informations de profil</h2>

<form:form method = "POST" action = "/escalade/register" modelAttribute="user" >

    <table>

        <tr>
            <td><form:label path = "username">Username :</form:label></td>
            <td><form:input path ="username" maxlength="20" required="required" value="${user.username}"/>
                <form:errors path="username" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path ="password">Password :</form:label></td>
            <td><form:password path ="password" minlength="8" required="required" value=""/>
                <form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path ="confirmPassword">Confirm Password :</form:label></td>
            <td><form:password path ="confirmPassword" minlength="8" required="required"/>
                <form:errors path="confirmPassword" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path = "email">Email : </form:label></td>
            <td><form:input path ="email" required="required" value="${user.email}"/>
                <form:errors path="email" cssClass="error"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>



</body>

</html>