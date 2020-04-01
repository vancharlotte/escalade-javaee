<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<h2>Recherche Topo</h2>

<form action="searchTopo" method="post">
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
            <td><label for="available"> Available : </label></td>
            <td><input type="checkbox" id="available" name="searchByAvailable"></td>
        </tr>
        <tr>
            <td>  <input type="Submit" value="Ok"/></td>
        </tr>

    </table>
</form>

<h2> Sites : </h2>

<c:if test="${ empty topoList}">

    <h4>pas de résultat</h4>

</c:if>

<c:if test="${not empty topoList}">


    <c:forEach var="topo" items="${topoList}">


        <li><c:out value="${topo.name}"/>

            <a href="${pageContext.request.contextPath}/topo?<c:out value="${topo.topoId}"/>"> consulter </a>

        </li>
    </c:forEach>

</c:if>

</body>
</html>