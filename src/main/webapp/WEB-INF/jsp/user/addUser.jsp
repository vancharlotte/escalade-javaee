<%--
  Created by IntelliJ IDEA.
  User: vanhu
  Date: 11/03/2020
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>add user</title>
    <style>
        .error{color:red}
    </style>
</head>

<body>
<h2>Informations de profil</h2>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
</html>

<c:if test="${ !empty username }"><p><c:out value="Bonjour, vous vous appelez ${ username }" /></p></c:if>

<form method="post" action="register">

    <table>

        <tr>
            <td><label for="username">Identifiant : </label></td>
            <td> <input type="text" name="username" id="username" /></td>
        </tr>
        <tr>
            <td><label for="password">Mot de passe : </label></td>
            <td> <input type="password" name="password" id="password" /></td>
        </tr>
        <tr>
            <td><label for="confirmPassword">Confirmer mot de passe : </label></td>
            <td> <input type="password" name="confirmPassword" id="confirmPassword" /></td>
        </tr>
        <tr>
            <td><label for="email">Email : </label></td>
            <td> <input type="email" name="email" id="email" /></td>
        </tr>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>



</body>

</html>