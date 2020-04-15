<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche utilisateur</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/fragments/style.css"%>
        <%@include file="/WEB-INF/fragments/stylesearch.css"%>
    </style>

</head>

<body>

<div class="container">

<div class = "search">
<h2>Recherche Utilisateur</h2>

<form action="searchUser" method="post">

    <label for="name"> Nom : </label><input type="text" id="name" name="searchByUsername">
    <input type="Submit" value="Ok"/>

</form>
</div>
<div class="result">
<c:if test="${ empty siteList}">

    <h4>pas de résultat</h4>

</c:if>

<c:if test="${not empty userList}">

    <h2> utilisateur : </h2>

    <c:forEach var="user" items="${userList}">


        <li><c:out value="${user.username}"/>

            <a href="${pageContext.request.contextPath}/page?<c:out value="${user.userId}"/>"> consulter </a>

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