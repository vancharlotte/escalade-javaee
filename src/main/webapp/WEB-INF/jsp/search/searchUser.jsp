<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche utilisateur</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<h2>Recherche Utilisateur</h2>

<form action="searchUser" method="post">

    <input type="text" id="name" name="search_criteria" value="name">
    <label for="name"> name </label><br>

    <input type="Submit" value="Ok"/>

</form>

<c:if test="${not empty userList}">

    <h2> utilisateur : </h2>

    <c:forEach var="user" items="${userList}">


        <li><c:out value="${user.name}"/>

            <a href="${pageContext.request.contextPath}/user?<c:out value="${user.userId}"/>"> consulter  </a>

        </li>
    </c:forEach>

</c:if>


</body>
</html>