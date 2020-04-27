<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> page de profil</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/pagestyle.css"%>

    </style>
</head>

<body>
<div class="container">

<c:if test="${user.username ne owner.username}">

    <button onclick="history.back()"> ◄ Retourner à la liste d'utilisateurs
    </button>
     </c:if>


    <div class="elt1">
        <h1> ${owner.username}</h1>
        <hr>

    </div>
    <hr>

    <div class="elt2">

        <c:if test="${user.username eq owner.username}">
            <a href="${pageContext.request.contextPath}/user/myTopo"> Mes topos </a>
            </br>
            <a href="${pageContext.request.contextPath}/user/myBooking"> Mes réservations </a>
            </br>
            <a href="${pageContext.request.contextPath}/user/editUser?userId=${owner.userId}"> Modifier les informations de mon profil </a>
            </br>
            <a href="${pageContext.request.contextPath}/user/editPassword?userId=${owner.userId}"> Modifier mon mot de passe </a>

        </c:if>


        <c:if test="${user.username ne owner.username}">

            <h2> Les topos de ${owner.username} : </h2>

            <table>
                <tr>
                    <th>Nom</th>
                    <th>Statut</th>
                </tr>
                <tr>

                    <c:forEach var="topo" items="${topoList}">

                    <td><a href="${pageContext.request.contextPath}/topo?topoId=<c:out value="${topo.topoId}"/>"> <c:out
                            value="${topo.name}"/> </a></td>
                    <td><c:if test="${(topo.available=true)}"> disponible </c:if>

                        <c:if test="${(topo.available=false)}"> indisponible </c:if></td>
                </tr>

                </c:forEach>
            </table>

        </c:if>
    </div>
</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
