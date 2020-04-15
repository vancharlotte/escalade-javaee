<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> mes réservations </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
        <%@include file="/WEB-INF/css/mybookingstyle.css" %>

    </style>


</head>

<body>
<div class="container">

    <div class="elt1">
    <h2> Mes topos</h2>
    <table>
        <tr>
            <th>Topo</th>
            <th>Statut</th>
            <th>Utilisateur</th>
            <th>Email</th>
            <th></th>

        </tr>

        <c:forEach var="entryR" items="${requestList}">
            <tr>
                <td><c:out value="${entryR.value.key.name}"/></td>
                <td><c:out value="${entryR.key.status}"/></td>
                <td><c:out value="${entryR.value.value.username}"/></td>
                <td><c:out value="${entryR.value.value.email}"/></td>
                <td>
                    <c:if test="${entryR.key.status=='en attente'}">

                        <a href="${pageContext.request.contextPath}/acceptBooking?<c:out value="${entryR.key.bookingId}"/>">
                            accepter </a>
                        <a href="${pageContext.request.contextPath}/rejectBooking?<c:out value="${entryR.key.bookingId}"/>">
                            refuser </a>

                    </c:if>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>

<div class="elt2">
    <h2> Mes demandes </h2>
    <table>
        <tr>
            <th>Topo</th>
            <th>Statut</th>
            <th>Propriétaire</th>
            <th></th>
        </tr>

        <c:forEach var="entryB" items="${bookingList}">
            <tr>
                <td><c:out value="${entryB.value.key.name}"/></td>
                <td><c:out value="${entryB.key.status}"/></td>
                <td><c:out value="${entryB.value.value.username}"/></td>
                <td>
                    <c:if test="${entryB.key.status=='en attente'}">
                        <a href="${pageContext.request.contextPath}/cancelBooking?<c:out value="${entryB.key.bookingId}"/>">
                            annuler </a>
                    </c:if>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>

</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
