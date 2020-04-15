<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> modifier commentaire</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style><%@include file="/WEB-INF/fragments/style.css"%></style>

</head>

<body>

<h2>modifier comment</h2>


<form method="post" action="editComment">

    <table>

        <tr>
            <td><label for="commentId"></label></td>
            <td><input type="hidden" name="commentId" id="commentId" value="${comment.commentId}"/></td>
        </tr>
        <tr>
            <td><label for="title">Titre : </label></td>
            <td><input type="text" name="title" id="title" value="${comment.title}"/></td>
        </tr>
        <tr>
            <td><label for="description">Description : </label></td>

            <td><textarea rows="5" cols="50" name="description" id="description" >${comment.description}</textarea>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>