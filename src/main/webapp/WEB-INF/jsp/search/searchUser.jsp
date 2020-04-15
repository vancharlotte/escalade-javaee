<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche utilisateur</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/stylesearch.css"%>
    </style>

</head>

<body>

<div class="container">

    <div class="result">
        <h2> Utilisateurs : </h2>

        <ul>

            <c:if test="${ empty userList}">
                <li>
                    <h4>pas de résultat</h4>
                </li>

            </c:if>

            <c:if test="${not empty userList}">
                <c:forEach var="user" items="${userList}">
                    <li>
                        <a href="${pageContext.request.contextPath}/page?<c:out value="${user.userId}"/>">
                            <strong> <c:out value="${user.username}"/></strong> </a>
                    </li>
                </c:forEach>
            </c:if>

        </ul>

    </div>
    <div class="search">

        <form action="searchUser" method="post">
            <h2>Recherche Utilisateur</h2>


            <label for="name"> Nom : </label><input type="text" id="name" name="searchByUsername">
            <input type="Submit" value="Ok"/>

        </form>
    </div>
</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>