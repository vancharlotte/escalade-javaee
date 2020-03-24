<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> site </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>


<h2>${site.name}</h2>
${site.location}
<br>
${site.description}
<b
${site.checked}
<br>

<c:if test="${not empty commentList}">
    <c:forEach var="entry" items="${commentMap}">

        <li>

            <c:out value="${entry.key.title}"/>
            <c:out value="${entry.key.time}"/>
            <c:out value="${entry.value}"/>

            <td><c:out value="${entry.key.description}"/></td>

        </li>
    </c:forEach>

</c:if>


<c:if test="${user.role=admin}">


    <a href="${pageContext.request.contextPath}/editSite?<c:out value="${site.siteId}"/>"> Modifier </a>
    <a href="${pageContext.request.contextPath}/deleteTopo?<c:out value="${site.siteId}"/>"> Supprimer </a>
    <a href="${pageContext.request.contextPath}/editStatus?<c:out value="${site.siteId}"/>"> Ami de l'escalade </a>


</c:if>
</body>
</html>
