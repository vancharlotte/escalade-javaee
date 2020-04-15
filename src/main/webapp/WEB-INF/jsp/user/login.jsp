<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> connexion</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/fragments/style.css" %>
        <%@include file="/WEB-INF/fragments/loginstyle.css" %>



    </style>
</head>

<body>
<div class="container">

<div class="login">

    <form method="post" action="login">

        <h1>Connexion</h1>

        <c:if test="${not empty message}">${message}</c:if>

        <label for="username">Identifiant : </label>
        <input type="text" name="username" id="username" placeholder="username.."/>
        <label for="password">Mot de passe : </label>
        <input type="password" name="password" id="password" placeholder="mot de passe.."/>

        <input type="submit" value="Submit"/>
    </form>
</div>
</div>


</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
