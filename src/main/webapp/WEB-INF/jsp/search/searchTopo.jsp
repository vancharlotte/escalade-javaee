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

    <input type="radio" id="name" name="search_criteria" value="name">
    <label for="name"> name </label><br>
    <input type="radio" id="location" name="search_criteria" value="location">
    <label for="location"> site</label><br>
    <input type="radio" id="user" name="search_criteria" value="user">
    <label for="user"> user</label>
    <input type="radio" id="available" name="search_criteria" value="available">
    <label for="available"> available</label>

    <input type="Submit" value="Ok"/>
</form>

<h2> Sites : </h2>

<c:if test="${ empty topoList}">

    <h3>pas de résultat</h3>

</c:if>

<c:if test="${not empty topoList}">


    <c:forEach var="topo" items="${topoList}">


        <li><c:out value="${topo.name}"/>

            <a href="${pageContext.request.contextPath}/site?<c:out value="${topo.topoId}"/>"> consulter  </a>

        </li>
    </c:forEach>

</c:if>

</body>
</html>