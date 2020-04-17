<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> topo </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
        <%@include file="/WEB-INF/css/mytopostyle.css"%>

    </style>
</head>

</head>

<body>
<div class="container">

    <div class="elt1">
        <c:if test="${not empty message}">
            ${message} <br>
        </c:if>
    </div>

    <div class="elt2">
        <a href="${pageContext.request.contextPath}/user/addTopo"> Ajouter un topo </a>
        <br>
    </div>

    <div class="elt3">
        <h2> Mes topos : </h2>

        <table>
            <tr>
                <th>Nom</th>
                <th>Statut</th>
                <th></th>

            </tr>

            <c:if test="${not empty list}">

                <c:forEach var="topo" items="${list}">
                    <tr>

                        <td class="name">
                            <a href="${pageContext.request.contextPath}/topo?<c:out value="${topo.topoId}"/>">
                                <c:out value="${topo.name}"/></a></td>
                        <td><c:if test="${topo.available==true}"> disponible </c:if>
                            <c:if test="${topo.available==false}"> réservé </c:if>
                        </td>
                        <td>

                            <a href="${pageContext.request.contextPath}/user/editTopo?<c:out value="${topo.topoId}"/>">
                                Modifier </a>
                            <a href="${pageContext.request.contextPath}/user/deleteTopo?<c:out value="${topo.topoId}"/>">
                                Supprimer </a>
                            <a href="${pageContext.request.contextPath}/user/editStatusTopo?<c:out value="${topo.topoId}"/>">
                                Changer Statut </a>
                        </td>
                    </tr>
                </c:forEach>

            </c:if>


        </table>

    </div>

</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
