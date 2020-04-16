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
        .bordure {
            border: solid 1px blueviolet;
            padding: 25px;
            border-radius: 5px;
        }
    </style>
</head>


<body>
<div class="container">

    <div class="elt1">
        <h1> ${topo.name}</h1>
        <hr>
    </div>

    <div class="line1">

        <div class="elt2">

            <p>
                par : ${owner.username}
                <br/> <br/>
                Où? ${topo.city}, ${topo.departement}
                <br/>
                date de parution : ${topo.releaseDate}
                <br/> <br/>
            </p>

            <p style="color: blueviolet">
                ${message}
                <br/> <br/>
            </p>
        </div>

        <div class="elt3">

            ${topo.description}
            <br/> <br/>
        </div>

    </div>

    <div class="elt4">

        <c:if test="${(topo.available=true) && (user.username ne owner.username)}">
            Voulez-vous réserver ce topo?
            <a href="${pageContext.request.contextPath}/booking?<c:out value="${topo.topoId}"/>"> Réserver </a>
        </c:if>

        <c:if test="${user.username eq owner.username}">

            <a href="${pageContext.request.contextPath}/user/editTopo?<c:out value="${topo.topoId}"/>">
                Modifier </a></li>
            <a href="${pageContext.request.contextPath}/user/deleteTopo?<c:out value="${topo.topoId}"/>">
                Supprimer </a></li>


        </c:if>

    </div>

</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
