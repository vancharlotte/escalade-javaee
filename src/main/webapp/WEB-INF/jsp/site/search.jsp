<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<h2>Recherche</h2>

<form action="search" method="post">

    <input type="search" size="20" name="search_name"/>
    <input type="Submit" value="Ok"/>

</form>


<c:if test="${not empty siteList}">

    <h2> Sites : </h2>

    <c:forEach var="site" items="${siteList}">


        <li><c:out value="${site.name}"/>

            <a href="${pageContext.request.contextPath}/site?<c:out value="${site.siteId}"/>"> consulter  </a>

        </li>
    </c:forEach>

</c:if>

</body>
</html>

