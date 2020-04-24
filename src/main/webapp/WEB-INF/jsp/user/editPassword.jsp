<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> modifier mot de passe</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
        <%@include file="/WEB-INF/css/formstyle.css" %>
    </style>
</head>

</head>

<body>


<div class="container">

    <div class="form">

        <h1>Modifier mon mot de passe</h1>

        <form method="post" action="editPassword" accept-charset="ISO-8859-1">
            <p style="color: darkcyan ">
                <c:if test="${not empty message}">${message}</c:if>
            </p>

            <label for="userId"></label>
            <input type="hidden" name="userId" id="userId" value="${user.userId}" required/>
            <label for="oldPassword">Ancien mot de passe : </label>
            <input type="password" name="oldPassword" id="oldPassword" required/>
            <label for="password">Nouveau mot de passe : </label>
            <input type="password" name="password" id="password"
                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                   title="il doit contenir au moins un chiffre, une minuscule, une majuscule et au moins 8 caractères" required/>
            <label for="confirmPassword">Confirmer le nouveau mot de passe : </label>
            <input type="password" name="confirmPassword" id="confirmPassword" required/>
            <input type="submit" value="Valider"/>

        </form>
    </div>

</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>