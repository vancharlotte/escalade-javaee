<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> modifier topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
        <%@include file="/WEB-INF/css/formstyle.css" %>
    </style>
</head>

</head>

<body>


<div class="container">

    <c:if test="${not empty message}">

        <td>${message}</td>

    </c:if>
    <div class="form">

        <h1>Modifier mon profil</h1>

        <form method="post" action="editUser" accept-charset="ISO-8859-1">
            <p style="color: darkcyan ">
                <c:if test="${not empty message}">${message}</c:if>
            </p>

            <label for="username">Identifiant : </label>
            <input type="text" id="username" name="username" value="{user.username}" required>
            <label for="password">Mot de passe : </label>
            <input type="password" name="password" id="password"
                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                   title="il doit contenir au moins un chiffre, une minuscule, une majuscule et au moins 8 caractères" required/>
            <label for="confirmPassword">Confirmer mot de passe : </label>
            <input type="password" name="confirmPassword" id="confirmPassword" required/>
            <label for="email">Email : </label>
            <input type="email" name="email" id="email" value="{user.email}" required/>
            <input type="submit" value="Valider"/>

        </form>
    </div>

</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>