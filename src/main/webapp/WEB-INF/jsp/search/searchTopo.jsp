<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/fragments/style.css"%>
        <%@include file="/WEB-INF/fragments/stylesearch.css"%>
    </style>

</head>

<body>
<div class="container">
    <div class="search">
        <h2>Recherche Topo</h2>

        <form action="searchTopo" method="post">

            <label for="name"> Nom : </label>
            <input type="text" id="name" name="searchByName">
            <label for="city"> Ville : </label>
            <input type="text" id="city" name="searchByCity">
            <label>Département : </label>
            <select name="searchByDepartement">
                <option value="00">sélectionner</option>
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select>

            <label for="available"> Available : </label>
            <input type="checkbox" id="available" name="searchByAvailable">
            <input type="Submit" value="Ok"/>

        </form>
    </div>
    <div class="result">
        <h2> topos : </h2>

        <c:if test="${ empty topoList}">

            <h4>pas de résultat</h4>

        </c:if>

        <c:if test="${not empty topoList}">


            <c:forEach var="topo" items="${topoList}">


                <li><c:out value="${topo.name}"/>

                    <a href="${pageContext.request.contextPath}/topo?<c:out value="${topo.topoId}"/>"> consulter </a>

                </li>
            </c:forEach>

        </c:if>
    </div>
</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>