<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> page de profil</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style><%@include file="/WEB-INF/fragments/style.css"%></style></head>
</head>

<body>

<h2> ${owner.username}</h2>


<c:if test="${user.username eq owner.username}">

    <a href="${pageContext.request.contextPath}/user/myTopo"> Mes topos </a>
    </br>
    <a href="${pageContext.request.contextPath}/user/myBooking"> Mes réservations </a>
</c:if>


<c:if test="${user.username ne owner.username}">

<h3><label>Les topos de ${owner.username} :  </label></h3>


    <c:forEach var="topo" items="${topoList}">

        <li><c:out value="${topo.name}"/>
            <c:if test="${(topo.available=true)}"> disponible </c:if>

            <c:if test="${(topo.available=false)}"> indisponible </c:if>



            <a href="${pageContext.request.contextPath}/topo?<c:out value="${topo.topoId}"/>"> consulter </a>

        </li>
    </c:forEach>

</c:if>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
