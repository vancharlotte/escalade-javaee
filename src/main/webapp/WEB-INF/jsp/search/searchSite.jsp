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
    <table>
        <tr>
            <td><label for="name"> Nom : </label></td>
            <td><input type="text" id="name" name="searchByName"></td>
        </tr>
        <tr>
            <td><label for="city"> Ville : </label></td>
            <td><input type="text" id="city" name="searchByCity"></td>
        </tr>
        <tr>
            <td><label>Département : </label></td>
            <td><select name="searchByDepartement">
                <option value="00">sélectionner</option>
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td><label>Cotation Minimale : </label></td>
            <td><select name="quotationMin">
                <option value="00">sélectionner</option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td><label>Cotation Maximale : </label></td>
            <td><select name="quotationMax">
                <option value="00">sélectionner</option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><label for="sector"> nombre de secteur :</label><br></td>
            <td><input type="number" id="sector" name="searchBySector"></td>
        </tr>
        <tr>
            <td><label for="checked"> Amis de l'escalade?</label></td>
            <td><input type="checkbox" id="checked" name="searchByChecked"></td>
        </tr>
        <tr>
            <td><input type="Submit" value="Ok"/></td>
        </tr>
    </table>
</form>

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


</body>
</html>