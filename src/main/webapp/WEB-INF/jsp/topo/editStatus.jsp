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
<form:form method = "POST" action = "/escalade/user/editStatus/${topoId}" modelAttribute="topo" >
    <h2> Topo ${topo.name} :</h2>

    <table>
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