<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<header>

    <title> liste site</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>

    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/listsitestyle.css"%>
    </style>
</header>


<body>
<div class="container">

    <div class="elt1">
        <a href="${pageContext.request.contextPath}/user/addSite"> Ajouter un site</a>
        <br>
    </div>

    <div class="elt2">
        <table>
            <tr>
                <th>Nom</th>
                <th>Ville</th>
                <th>Département</th>
                <th>Description</th>
            </tr>

            <c:if test="${not empty sites}">
            <c:forEach var="site" items="${sites}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/site?<c:out value="${site.siteId}"/>">
                    <strong> <c:out value="${site.name}"/></strong> </a>
                </td>
                <td><c:out value="${site.city}"/></td>
                <td><c:out value="${site.departement}"/></td>
                <td><c:out value="${site.description}"/></td>

                </c:forEach>

                </c:if>
            </tr>
        </table>
        </br>
        </br>
    </div>


    <div class="pagination">


        <c:if test="${pageNumber  != 1}">
            <a href="${pageContext.request.contextPath}/listSite?<c:out value="${pageNumber - 1}"/>">
                &laquo;</a>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:if test="${ pageNumber  == i}">
                <a class="active" href="${pageContext.request.contextPath}/listSite?<c:out value="${i}"/>">
                <c:out value="${i}"/></a>
            </c:if>
            <c:if test="${ pageNumber  != i}">
        <a href="${pageContext.request.contextPath}/listSite?<c:out value="${i}"/>">
            <c:out value="${i}"/></a>
            </c:if>
        </c:forEach>

        <c:if test="${pageNumber != noOfPages}">
            <a href="${pageContext.request.contextPath}/listSite?<c:out value="${pageNumber + 1}"/>">
                &raquo;</a>
        </c:if>

    </div>

</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>