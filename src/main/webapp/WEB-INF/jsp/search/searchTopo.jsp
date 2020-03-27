<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<h2>Recherche Topo</h2>

<form action="searchTopo" method="post">

    <input type="text" id="name" name="searchByName">
    <label for="name"> name </label><br>
    <input type="text" id="location" name="searchByLocation">
    <label for="location"> site</label><br>
    <input type="checkbox" id="available" name="searchByAvailable">
    <label for="available"> available</label>

    <input type="Submit" value="Ok"/>
</form>

<h2> Sites : </h2>

<c:if test="${ empty topoList}">

    <h4>pas de résultat</h4>

</c:if>

<c:if test="${not empty topoList}">


    <c:forEach var="topo" items="${topoList}">


        <li><c:out value="${topo.name}"/>

            <a href="${pageContext.request.contextPath}/topo?<c:out value="${topo.topoId}"/>"> consulter  </a>

        </li>
    </c:forEach>

</c:if>

</body>
</html>