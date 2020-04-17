<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/stylesearch.css"%>
    </style>

</head>

<body>
<div class="container">
    <div class="result">
        <h2> topos : </h2>

        <ul>


            <c:if test="${ empty topoList}">
                <li>
                    <h4>pas de résultat</h4>
                </li>

            </c:if>

            <c:if test="${not empty topoList}">
                <c:forEach var="topo" items="${topoList}">
                    <li>
                        <a href="${pageContext.request.contextPath}/topo?<c:out value="${topo.topoId}"/>">
                            <strong> <c:out value="${topo.name}"/></strong> </a>
                    </li>
                </c:forEach>
            </c:if>

        </ul>
    </div>
    <div class="search">

        <form action="searchTopo" method="post">
            <h2>Recherche Topo</h2>


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
            </br>

            <label for="available"> Available : </label>
            <input type="checkbox" id="available" name="searchByAvailable">
            </br></br>
            <input type="Submit" value="recherche"/>

        </form>
    </div>
</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>