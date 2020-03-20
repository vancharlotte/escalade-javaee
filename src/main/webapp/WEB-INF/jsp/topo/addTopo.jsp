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

<c:if test="${not empty message}">

    <td>${message}</td>

</c:if>


<form method="post" action="addTopo" >

    <table>

        <tr>
            <td><label for="name">Nom : </label></td>
            <td> <input type="text" name="name" id="name" value="${topo.name}"/></td>
        </tr>
        <tr>
            <td><label for="location">Location : </label></td>
            <td> <input type="text" name="location" id="location" value="${topo.location}" /></td>
        </tr>
        <tr>
            <td><label for="releaseDate">Date de parution : </label></td>
            <td> <input type="date" name="releaseDate" id="releaseDate" value="${topo.releaseDate}"/></td>
        </tr>
        <tr>
            <td><label for="description">Description : </label></td>
            <td> <input type="text" name="description" id="description" value="${topo.description}" /></td>
        </tr>
        <tr>
            <td> Disponible :</td>
            <td> <input type="radio" name="available" id="true" value="true" checked />
                <label for="true">Yes</label> </td>
            <td> <input type="radio" name="available" id="false" value="false"/>
                <label for="false">No</label>
            </td>

        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>



</body>

</html>