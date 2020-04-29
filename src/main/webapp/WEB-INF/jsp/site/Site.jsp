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

    <button onclick="history.back()"> ◄ Retourner à la liste des sites d'escalade
    </button>

    <div class="line1">
        <h1> ${site.name}</h1>
        <hr>
    </div>

    <div class="line2">
        <div class="bloc1">

            <div class="elt1">
                <aside>
                    <c:if test="${site.checked==true}">
                        <span title="site d'escalade certifié par les amis de l'escalade" style="font-size:48px">
                            &#129495;
                        </span>
                        <br> <br>
                        <strong> Ami de l'escalade </strong>
                    </c:if>
                </aside>
                <br/>
                <strong>Où?</strong> ${site.city}, ${site.departement}
                <br/>
                <strong>nombre de voies :</strong> ${site.nbRoutes}
                <br/>
                <strong>cotation :</strong> de ${site.quotationMin} à ${site.quotationMax}


                <p style="color: blueviolet">
                    ${message}
                </p>

                <div class="option">
                    <br/>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">

                        <a href="${pageContext.request.contextPath}/admin/editSite?siteId=<c:out value="${site.siteId}"/>">
                            Modifier </a>
                        <a href="${pageContext.request.contextPath}/admin/deleteSite?siteId=<c:out value="${site.siteId}"/>">
                            Supprimer </a>
                        <a href="${pageContext.request.contextPath}/admin/editChecked?siteId=<c:out value="${site.siteId}"/>">
                            Ami de l'escalade </a>

                    </sec:authorize>

                </div>
                <br/>
                <hr>

            </div>

            <div class="elt2">
                ${site.description}
            </div>
        </div>

        <div class="bloc2">

            <div class="elt3">
                <h3> Commentaires :</h3>
                <sec:authorize access="isAuthenticated()">

                    <a href="${pageContext.request.contextPath}/user/addComment?siteId=<c:out value="${site.siteId}"/>">
                        Ajouter un
                        commentaire </a>
                    <br/> <br/>

                </sec:authorize>
            </div>
            <div class="elt4">

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
                            </br>
                            <a href="${pageContext.request.contextPath}/admin/deleteComment?commentId=<c:out value="${entry.key.commentId}"/>">
                                Supprimer </a>
                            <a href="${pageContext.request.contextPath}/admin/editComment?commentId=<c:out value="${entry.key.commentId}"/>">
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

</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>
