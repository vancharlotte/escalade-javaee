<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> inscription</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

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