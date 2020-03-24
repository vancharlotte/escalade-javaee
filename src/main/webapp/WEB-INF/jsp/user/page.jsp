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

<a href="${pageContext.request.contextPath}/myTopo"> Mes topos </a>
<a href="${pageContext.request.contextPath}/myBooking"> Mes réservations </a>

</body>
</html>
