<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> modifier topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<c:if test="${not empty message}">

    <td>${message}</td>

</c:if>


<form method="post" url="" action="editTopo">

    <table>

        <tr>
            <td><label for="topoId"></label></td>
            <td><input type="hidden" name="topoId" id="topoId" value="${topo.topoId}"/></td>
        </tr>
        <tr>
            <td><label for="name">Nom : </label></td>
            <td><input type="text" name="name" id="name" value="${topo.name}"/></td>
        </tr>
        <tr>
            <td><label for="city">Ville : </label></td>
            <td><input type="text" name="city" id="city" value="${topo.city}"/></td>
        </tr>
        <tr>
            <td><label>Département : </label></td>
            <td><select name="departement" >
                <option value="${topo.departement}">${topo.departement}</option>
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><label for="releaseDate">Date de parution : </label></td>
            <td><input type="date" name="releaseDate" id="releaseDate" value="${topo.releaseDate}"/></td>
        </tr>
        <tr>
            <td><label for="description">Description : </label></td>
            <td><textarea rows="5" cols="50" name="description" id="description">${topo.description}</textarea>
            </td>
        </tr>
        <tr>
            <td> Disponible :</td>
            <td><input type="radio" name="available" id="true" value="true" checked/>
                <label for="true">Yes</label>
                <input type="radio" name="available" id="false" value="false"/>
                <label for="false">No</label>
            </td>

        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>


</body>

</html>