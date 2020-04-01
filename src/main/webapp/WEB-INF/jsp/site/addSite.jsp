<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> nouveau site </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>
<h2> nouveau site</h2>


<form method="post" action="addSite">

    <table>

        <tr>
            <td><label for="name">Nom : </label></td>
            <td><input type="text" name="name" id="name"/></td>
        </tr>
        <tr>
            <td><label for="city">Ville : </label></td>
            <td><input type="text" name="city" id="city"/></td>
        </tr>
        <tr>
            <td><label>Departement : </label></td>
            <td><select name="departement" >
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><label>Cotation Minimale : </label></td>
            <td><select name="quotationMin">
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td><label>Cotation Maximale : </label></td>
            <td><select name="quotationMax">
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><label for="nbRoutes"> Nombre de voies : </label></td>
            <td><input type="text" name="nbRoutes" id="nbRoutes"/></td>
        </tr>
        <tr>
            <td><label for="description">Description : </label></td>

            <td><textarea rows="5" cols="50" name="description" id="description"></textarea>
            </td>
        </tr>
        <tr>
            <td> Amis de l'escalade :</td>
            <td><input type="radio" name="ckecked" id="true" value="true"/>
                <label for="true">Yes</label>
                <input type="radio" name="checked" id="false" value="false" checked/>
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