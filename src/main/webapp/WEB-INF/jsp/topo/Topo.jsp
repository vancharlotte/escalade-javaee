<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>add user</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>
<br>

<h2>${topo.name}</h2>
<br>
<h2>${user.name}</h2>
<br>
<h2>${topo.location}</h2>
<br>
<h2>${topo.releaseDate}</h2>
<br>
<h2>${topo.description}</h2>
<br>
<h2>${topo.available}</h2>
<br>


<c:if test="${topo.available=true}">


    <a href="${pageContext.request.contextPath}/booking?<c:out value="${topo.topoId}"/>"> Réserver </a>


</c:if>
</body>
</html>
