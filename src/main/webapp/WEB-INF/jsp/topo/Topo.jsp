<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/topostyle.css"%>

    </style>
</head>


<body>
<div class="container">

    <button onclick="history.back()"> ◄ Retourner à la liste des topos
    </button>


    <div class="elt1">
        <h1> ${topo.name}    </h1>

        <hr>
    </div>

    <div class="line1">

        <div class="elt2">

            <p class="info">
                <br/>
                <strong>Où?</strong> ${topo.city}, ${topo.departement}
                <br/><br/>
                <strong>date de parution :</strong> ${topo.releaseDate}
                <br/> <br/>
            <hr>

            </p>

            <p style="color: blueviolet">
                <br/>
                <c:if test="${ empty error}">${message}<br><br></c:if>
                <c:if test="${not empty error}">Vous avez déjà fait une demande de réservation pour ce topo. Celle-ci est toujours en attente.<br><br></c:if>

            </p>
            <div class="elt4">


                <c:if test="${(topo.available=true) && (user.username ne owner.username)}">


                    Voulez-vous réserver ce topo?
                    <a href="${pageContext.request.contextPath}/booking?topoId=<c:out value="${topo.topoId}"/>">
                        Réserver </a>
                </c:if>

                <c:if test="${user.username eq owner.username}">

                    <a href="${pageContext.request.contextPath}/user/editTopo?topoId=<c:out value="${topo.topoId}"/>">
                        Modifier </a></li>
                    <a href="${pageContext.request.contextPath}/user/deleteTopo?topoId=<c:out value="${topo.topoId}"/>">
                        Supprimer </a></li>


                </c:if>

            </div>
        </div>

        <div class="elt3">
            <h4>   propriétaire : ${owner.username} </h4>
            <br/> <br/>
            ${topo.description}
        </div>

    </div>


</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
