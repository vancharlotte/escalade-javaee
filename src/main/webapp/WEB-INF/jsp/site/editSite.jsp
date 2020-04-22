<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<head>
    <title> modifier site </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
        <%@include file="/WEB-INF/css/formstyle.css" %>

    </style>
</head>

<body>

<div class="container">
    <div class="form">

        <h1>Modifier le site</h1>

        <p style="color: darkcyan ">
            <c:if test="${not empty message}">${message}</c:if>
        </p>

        <form method="post" action="editSite" accept-charset="ISO-8859-1">


            <label for="siteId"></label>
            <input type="hidden" name="siteId" id="siteId" value="${site.siteId}" />

            <label for="name">Nom : </label>
            <input type="text" name="name" id="name" value="${site.name}" maxlength="50" required/>

            <label for="city">Ville : </label>
            <input type="text" name="city" id="city" value="${site.city}" required/>

            <label>Departement : </label>
            <select name="departement" required>
                <option value="${site.departement}" selected hidden>${site.departement}</option>
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select>

            <label>Cotation Minimale : </label>
            <select name="quotationMin" required>
                <option value="${site.quotationMin}" selected hidden>${site.quotationMin}</option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select>

            <label>Cotation Maximale : </label>
            <select name="quotationMax" required>
                <option value="${site.quotationMax}" selected hidden>${site.quotationMax}</option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select>

            <label for="nbRoutes"> Nombre de voies : </label>
            <input type="number"  min="0" name="nbRoutes" id="nbRoutes" value="${site.nbRoutes}" required/>

            <label for="description">Description : </label>
            <textarea rows="5" cols="50" name="description" id="description" minlength="10" required>${site.description}</textarea>


            Amis de l'escalade :

            <input type="radio" name="checked" id="true" value="true" checked/>
            <label for="true">Yes</label>
            <input type="radio" name="checked" id="false" value="false"/>
            <label for="false">No</label>

            <input type="submit" value="Submit"/>

        </form>
    </div>
</div>


</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>



