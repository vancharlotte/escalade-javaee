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

    <table>
        <tr>
            <td><label for="name"> Nom : </label></td>
            <td><input type="text" id="name" name="searchByUsername"></td>
        </tr>
        <tr>
            <td><input type="Submit" value="Ok"/></td>
        </tr>
    </table>

</form>

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


</body>
</html>