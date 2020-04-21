<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> modifier commentaire</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
        <%@include file="/WEB-INF/css/formstyle.css" %>

    </style>

</head>

<body>

<div class="container">

<div class="form">

<h2>modifier le commentaire</h2>

<form method="post" action="editComment">


    <label for="commentId"></label>
    <input type="hidden" name="commentId" id="commentId" value="${comment.commentId}"/>

    <label for="title">Titre : </label>
    <input type="text" name="title" id="title" value="${comment.title}" minlength="2" maxlength="20" required/>

    <label for="description">Description : </label>
    <textarea rows="5" cols="50" name="description" id="description" minlength="10" maxlength="300" required>
        ${comment.description}</textarea>

    <input type="submit" value="Submit"/></td>

</form>
</div>
</div>

</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>