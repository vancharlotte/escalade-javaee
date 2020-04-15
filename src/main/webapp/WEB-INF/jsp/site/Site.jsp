<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Site</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <style>
        .bordure {
            border: solid 1px blueviolet;
            padding: 25px;
            border-radius: 5px;
        }
    </style>
</head>

<body>
<br>
<h2>${site.name}</h2>
<div style="overflow-x:auto;">

    <table>
        <tr>
            <td>
                Où? ${site.city}, ${site.departement}
                <br/>
                nombre de voies : ${site.nbRoutes}
                <br/>
                cotation : de ${site.quotationMin} à ${site.quotationMax} <br/>
            </td>
        </tr>
        <tr>
            <td style="color: blueviolet">
                ${message}
                <br/>
            </td>
        </tr>
        <tr>
            <td class=bordure>

                ${site.description}
                <br/> <br/>
            </td>
        </tr>
    </table>
</div>
<div>
    <h4> Commentaires :</h4>
    <sec:authorize access="isAuthenticated()">

        <a href="${pageContext.request.contextPath}/user/addComment?<c:out value="${site.siteId}"/>"> Ajouter un
            commentaire </a>
        <br/> <br/>

    </sec:authorize>
    <table>
        <tr>

            <td class=bordure>
                <c:if test="${empty commentList}">
                    pas de commentaire
                </c:if>

                <c:if test="${not empty commentList}">
                    <c:forEach var="entry" items="${commentMap}">

                        <li>

                            <c:out value="${entry.key.title}"/>
                            par <c:out value="${entry.value}"/>
                            <c:out value="${entry.key.time}"/>
                            <br/>
                            <c:out value="${entry.key.description}"/>
                            <br/>

                            <sec:authorize access="hasRole('ROLE_ADMIN')">

                                <a href="${pageContext.request.contextPath}/admin/deleteComment?<c:out value="${entry.key.commentId}"/>">
                                    Supprimer </a>
                                <a href="${pageContext.request.contextPath}/admin/editComment?<c:out value="${entry.key.commentId}"/>">
                                    Modifier </a>
                                <br/>

                            </sec:authorize>

                        </li>
                    </c:forEach>

                </c:if>
            </td>
        </tr>
    </table>
</div>
<div>
    <br/>
    <br/>

    <sec:authorize access="hasRole('ROLE_ADMIN')">

        <a href="${pageContext.request.contextPath}/admin/editSite?<c:out value="${site.siteId}"/>"> Modifier </a>
        <a href="${pageContext.request.contextPath}/admin/deleteSite?<c:out value="${site.siteId}"/>"> Supprimer </a>
        <a href="${pageContext.request.contextPath}/admin/editChecked?<c:out value="${site.siteId}"/>"> Ami de
            l'escalade </a>

    </sec:authorize>

</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
