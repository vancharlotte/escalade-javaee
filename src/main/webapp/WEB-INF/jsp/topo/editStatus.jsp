<%@ taglib prefix="form" uri="" %>
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
    <title>add topo</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>

<body>

<h2> Topo ${topo.name} :</h2>

<form>

    <table>
        <tr>
            <td>Available :</td>

        <tr>
            <td> Disponible :</td>
            <td><input type="radio" name="available" id="true" value="true"/>
                <label for="true">Yes</label></td>
            <td><input type="radio" name="available" id="false" value="false"/>
                <label for="false">No</label>
            </td>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>


</body>

</html>