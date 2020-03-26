<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> mes réservations </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<h2> Mes topos</h2>

<c:forEach var="booking" items="${requestList}">
    <li>

        <c:out value="${booking.user.username}"/>
        <c:out value="${booking.status}"/>
        <c:out value="${booking.topo.name}"/>

        <c:if test="${booking.status=='en attente'}">

            <a href="${pageContext.request.contextPath}/deleteBooking?<c:out value="${booking.bookingId}"/>">
                accepter </a>
            <a href="${pageContext.request.contextPath}/acceptBooking?<c:out value="${booking.bookingId}"/>">
                refuser </a>

        </c:if>
    </li>
</c:forEach>

<h2> Mes demandes</h2>

<c:forEach var="booking" items="${bookingList}">

    <li><c:out value="${booking.topo.name}"/>
        <c:out value="${booking.status}"/>
        <c:out value="${booking.user.username}"/>

        <c:if test="${booking.status=='en attente'}">

            <a href="${pageContext.request.contextPath}/cancelBooking?<c:out value="${booking.bookingId}"/>">
                annuler </a>

        </c:if>

    </li>
</c:forEach>

</body>
</html>
