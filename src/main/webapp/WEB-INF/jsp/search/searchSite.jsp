<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche site</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>
<h2>Recherche Site</h2>

<form action="searchSite" method="POST">

    <input type="text" id="name" name="searchByName" >
    <label for="name"> name </label><br>

    <input type="text" id="location" name="searchByLocation" >
    <label for="location"> location</label><br>

    <input type="text" id="quotation" name="searchByQuotation">
    <label for="quotation"> quotation</label><br>

    <input type="number" id="sector" name="searchBySector" >
    <label for="sector"> nb sector</label><br>

    <input type="checkbox" id="checked" name="searchByChecked">
    <label for="checked"> checked</label>

    <input type="Submit" value="Ok"/>

</form>

<c:if test="${ empty siteList}">


<h4>pas de résultat</h4>

</c:if>

<c:if test="${not empty siteList}">

    <h2> Sites : </h2>

    <c:forEach var="site" items="${siteList}">


        <li><c:out value="${site.name}"/>

            <a href="${pageContext.request.contextPath}/site?<c:out value="${site.siteId}"/>"> consulter  </a>

        </li>
    </c:forEach>

</c:if>


</body>
</html>