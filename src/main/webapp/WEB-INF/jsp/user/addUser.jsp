<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> inscription</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
        <%@include file="/WEB-INF/css/loginstyle.css" %>
    </style>
</head>

<body>

<div class="container">

    <div class="form">

        <h1>Inscription</h1>

        <form method="post" action="register">

            <label for="username">Identifiant : </label>
            <input type="text" id="username" name="username" placeholder="username..">
            <label for="password">Mot de passe : </label>
            <input type="password" name="password" id="password" placeholder="mot de passe.."/>
            <label for="confirmPassword">Confirmer mot de passe : </label>
            <input type="password" name="confirmPassword" id="confirmPassword" placeholder="confirmer mot de passe.."/>
            <label for="email">Email : </label>
            <input type="email" name="email" id="email" placeholder="adresse email.."/>
            <input type="submit" value="Submit">

        </form>
    </div>
</div>



</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>