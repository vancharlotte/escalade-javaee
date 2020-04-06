<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> topo </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<c:if test="${not empty message}">

    <td>${message}</td>
    <br>

</c:if>

<a href="${pageContext.request.contextPath}/user/addTopo"> Ajouter un topo </a>
<br>


<h2> Mes topos : </h2>

<c:if test="${not empty list}">

    <c:forEach var="topo" items="${list}">


        <li><c:out value="${topo.name}"/>
            <c:if test="${topo.available==true}"> disponible </c:if>
            <c:if test="${topo.available==false}"> réservé </c:if>

            <a href="${pageContext.request.contextPath}/topo?<c:out value="${topo.topoId}"/>"> Consulter </a>
            <a href="${pageContext.request.contextPath}/user/editTopo?<c:out value="${topo.topoId}"/>"> Modifier </a>
            <a href="${pageContext.request.contextPath}/user/deleteTopo?<c:out value="${topo.topoId}"/>"> Supprimer </a>
            <a href="${pageContext.request.contextPath}/user/editStatusTopo?<c:out value="${topo.topoId}"/>"> Changer Statut </a>


        </li>
    </c:forEach>

</c:if>


</body>
</html>
