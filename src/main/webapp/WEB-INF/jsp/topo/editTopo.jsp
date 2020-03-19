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
    <title>add topo</title>
    <style>
        .error{color:red}
    </style>
</head>

<body>
<h2> Topo :</h2>
<form:form method = "POST" action = "/escalade/user/editTopo/${topoId}" modelAttribute="topo" >


    <table>
        <tr>
            <td><form:label path = "name">Name :</form:label></td>
            <td><form:input path ="name" maxlength="20" required="required" value="${topo.name}"/>
                <form:errors path="name" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path ="location">Location :</form:label></td>
            <td><form:input path ="location"  required="required" value="${topo.location}"/>
                <form:errors path="location" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path ="releaseDate">Release Date :</form:label></td>
            <td><form:input path ="releaseDate" required="required" value="dd/MM/yyyy"/>
                <form:errors path="releaseDate" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path ="description">Description :</form:label></td>
            <td><form:input path ="description" minlength="20" maxlength="200" required="required" value="${topo.description}"/>
                <form:errors path="description" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Available :</td>
            <td>
                <form:radiobutton path="available" value="true" /> Yes
                <form:radiobutton path="available" value="false" /> No
                <form:errors path="available" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>



</body>

</html>