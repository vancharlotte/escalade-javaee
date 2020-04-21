<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> nouveau topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/formstyle.css"%>

    </style>

</head>

</head>

<body>
<div class="container">
    <div class="form">

        <h1>Nouveau Topo</h1>

        <form method="post" action="addTopo">
            <p style="color: darkcyan ">
                <c:if test="${not empty message}">${message}</c:if>
            </p>

            <label for="topoId"></label>
            <input type="hidden" name="topoId" id="topoId" value="${topo.topoId}"/>
            <label for="name">Nom : </label>
            <input type="text" name="name" id="name" maxlength="20" required/>
            <label for="city">Ville : </label>
            <input type="text" name="city" id="city" required/>
            <label>Département : </label>
            <select name="departement">
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select>
            <label for="releaseDate">Date de parution : </label>
            <input type="date" name="releaseDate" id="releaseDate" required/>
            <label for="description">Description : </label>
            <textarea rows="5" cols="50" name="description" id="description" minlength="10" maxlength="300" required></textarea>
            Disponible :
            <input type="radio" name="available" id="true" value="true" checked/>
            <label for="true">Yes</label>
            <input type="radio" name="available" id="false" value="false"/>
            <label for="false">No</label>
            <input type="submit" value="Valider"/>

        </form>
    </div>

</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>