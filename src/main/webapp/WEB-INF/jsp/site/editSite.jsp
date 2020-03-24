<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> modifier site </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>


<form method="post" action="editSite">

    <table>

        <tr>
            <td><label for="siteId"></label></td>
            <td><input type="hidden" name="siteId" id="siteId" value="${site.siteId}"/></td>
        </tr>
        <tr>
            <td><label for="name">Nom : </label></td>
            <td><input type="text" name="name" id="name" value="${site.name}"/></td>
        </tr>
        <tr>
            <td><label for="location">Location : </label></td>
            <td><input type="text" name="location" id="location" value="${site.location}"/></td>
        </tr>
        <tr>
            <td><label for="description">Description : </label></td>
            <td><textarea rows="5" cols="50" name="description" id="description">${site.description}</textarea>
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