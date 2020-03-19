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
    <title>add comment</title>
    <style>
        .error{color:red}
    </style>
</head>

<body>
<h2>Commentaire :</h2>
<form:form method = "POST" action = "/escalade/comment" modelAttribute="comment" >

    <table>

        <tr>
            <td><form:label path = "title">Username :</form:label></td>
            <td><form:input path ="title" maxlength="20" required="required" value="title"/>
                <form:errors path="title" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path ="description">Password :</form:label></td>
            <td><form:input path ="description" minlength="20" maxlength="200" required="description"/>
                <form:errors path="description" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>



</body>

</html>