<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> nouveau commentaire</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/formstyle.css"%>

    </style>

</head>

<body>

<div class="container">
    <div class="form">
        <h2>nouveau commentaire</h2>


        <form method="post" action="addComment">

            <input type="hidden" id="site" name="site" value="${site.siteId}">
            <h4 style="color: darkcyan"> Vous commentez le site d'escalade : <c:out value="${site.name}"/></h4>


            <label for="title">Titre : </label>
            <input type="text" name="title" id="title" minlength="2" maxlength="20" required/>

            <label for="description">Description : </label>
            <textarea rows="5" cols="50" name="description" id="description" minlength="10" maxlength="300"
                      required></textarea>


            <input type="submit" value="Submit"/>

        </form>
    </div>
</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>