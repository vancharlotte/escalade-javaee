<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<h1>Login</h1>


</form>
<td>Connexion</td>

<form:form method="POST" action="/escalade/login" modelAttribute="login">

    <table>

        <tr>
            <td><form:label path="username">Username :</form:label></td>
            <td><form:input path="username" required="required"/>
                <form:errors path="username" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password :</form:label></td>
            <td><form:input path="password" minlength="8" required="required"/>
                <form:errors path="password" cssClass="error"/></td>

        </tr>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>


    </table>
</form:form>
</body>
</html>