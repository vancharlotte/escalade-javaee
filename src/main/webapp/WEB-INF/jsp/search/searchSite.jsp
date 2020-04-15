<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<header>
    <title> recherche site</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>

    <style>
        <%@include file="/WEB-INF/fragments/style.css"%>
        <%@include file="/WEB-INF/fragments/stylesearch.css"%>



    </style>

</header>

<body>

<div class="container">
    <div class="search">


        <form action="searchSite" method="POST">

            <h2>Recherche Site</h2>

            <label for="checked"> Amis de l'escalade?</label>
            <input type="checkbox" id="checked" name="searchByChecked">
            <br><br>

            <label for="name"> Nom : </label>
            <input type="text" id="name" name="searchByName">
            <label for="city"> Ville : </label>
            <input type="text" id="city" name="searchByCity">
            <label>Département : </label>
            <select name="searchByDepartement">
                <option value="00">sélectionner</option>
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select>
            <label>Cotation : </label>
            <select name="searchByQuotation">
                <option value="">sélectionner</option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select>


            <input type="Submit" value="Ok"/>

        </form>
    </div>
    <div class="result">
        <c:if test="${ empty siteList}">


            <h4>pas de résultat</h4>

        </c:if>

        <c:if test="${not empty siteList}">

            <h2> Sites : </h2>

            <c:forEach var="site" items="${siteList}">


                <li><c:out value="${site.name}"/>

                    <a href="${pageContext.request.contextPath}/site?<c:out value="${site.siteId}"/>"> consulter </a>

                </li>
            </c:forEach>

        </c:if>
    </div>
</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>