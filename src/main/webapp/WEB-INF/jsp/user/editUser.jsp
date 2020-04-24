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

    <div class="form">

        <h1>Modifier mes informations</h1>

        <form method="post" action="editUser" accept-charset="ISO-8859-1">
            <p style="color: darkcyan ">
                <c:if test="${valid eq 'true'}">Vos informations ont été mises à jour.</c:if>
            </p>

            <label for="userId"></label>
            <input type="hidden" name="userId" id="userId" value="${user.userId}" required/>
            <label for="username">Identifiant : </label>
            <input type="text" id="username" name="username" value="${user.username}" required>
            <label for="email">Email : </label>
            <input type="email" name="email" id="email" value="${user.email}" required/>

            <input type="submit" value="Valider"/>

        </form>
    </div>

</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>