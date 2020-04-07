<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> nouveau commentaire</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<h2>nouveau commentaire</h2>


<form method="post" action="addComment">

    <input type="hidden" id="site" name="site" value="${site.siteId}">
   <h4> Vous commentez le site d'escalade :     <c:out value="${site.name}"/></h4>

    <table>

        <tr>
            <td><label for="title">Titre : </label></td>
            <td><input type="text" name="title" id="title"/></td>
        </tr>
        <tr>
            <td><label for="description">Description : </label></td>

            <td><textarea rows="5" cols="50" name="description" id="description"></textarea>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>


</body>

</html>