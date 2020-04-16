<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Site</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/sitestyle.css"%>
    </style>
</head>

<body>
<div class="container">
    <div class="elt1">
        <h1> ${site.name}</h1>
        <hr>
    </div>

    <div class="line1">

        <div class="elt2">
            <c:if test="${site.checked==true}">
                Certifié Ami de l'escalade !!!!
            </c:if>
            <br/>
            <br/>

            Où? ${site.city}, ${site.departement}
            <br/>
            nombre de voies : ${site.nbRoutes}
            <br/>
            cotation : de ${site.quotationMin} à ${site.quotationMax}
            <br/>

            <p style="color: blueviolet">
                ${message}
            </p>

            <div class="option">
                <br/>
                <br/>

                <sec:authorize access="hasRole('ROLE_ADMIN')">

                    <a href="${pageContext.request.contextPath}/admin/editSite?<c:out value="${site.siteId}"/>">
                        Modifier </a>
                    <a href="${pageContext.request.contextPath}/admin/deleteSite?<c:out value="${site.siteId}"/>">
                        Supprimer </a>
                    <a href="${pageContext.request.contextPath}/admin/editChecked?<c:out value="${site.siteId}"/>"> Ami
                        de
                        l'escalade </a>

                </sec:authorize>

            </div>
        </div>

        <div class="elt3">
            ${site.description}
        </div>
    </div>

    <div class="line2">

        <div class="elt5">
            <h3> Commentaires :</h3>
            <sec:authorize access="isAuthenticated()">

                <a href="${pageContext.request.contextPath}/user/addComment?<c:out value="${site.siteId}"/>"> Ajouter un
                    commentaire </a>
                <br/> <br/>

            </sec:authorize>
        </div>
        <div class="elt6">

            <c:if test="${empty commentList}">
                pas de commentaire
            </c:if>

            <c:if test="${not empty commentList}">
                <c:forEach var="entry" items="${commentMap}">

                    <c:out value="${entry.key.title}"/>
                    par <c:out value="${entry.value}"/>
                    <c:out value="${entry.key.time}"/>
                    <br/>
                    <c:out value="${entry.key.description}"/>

                    <sec:authorize access="hasRole('ROLE_ADMIN')">

                        <a href="${pageContext.request.contextPath}/admin/deleteComment?<c:out value="${entry.key.commentId}"/>">
                            Supprimer </a>
                        <a href="${pageContext.request.contextPath}/admin/editComment?<c:out value="${entry.key.commentId}"/>">
                            Modifier </a>

                    </sec:authorize>
                    <hr>

                </c:forEach>

            </c:if>
            </td>
            </tr>
            </table>
        </div>
    </div>
</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
