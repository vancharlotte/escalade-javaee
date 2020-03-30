<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> inscription</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<h2> Page de profil</h2>

<h4>${message}</h4>

<c:if test="${user.username ne owner.username}">
    <a href="${pageContext.request.contextPath}/myTopo"> Mes topos </a>
    <a href="${pageContext.request.contextPath}/myBooking"> Mes réservations </a>
</c:if>

<c:if test="${user.username ne owner.username}">
    list des topos de cet utilisateur (owner de la page).

</c:if>

</body>
</html>
