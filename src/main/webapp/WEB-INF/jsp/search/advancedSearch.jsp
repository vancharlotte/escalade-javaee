<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
        <%@include file="/WEB-INF/css/stylesearch.css"%>

    </style>

</head>

<body>
<div class="container">
<div class="search">


<h2>Recherche</h2>

<form action="search" method="post" accept-charset="ISO-8859-1">

    <label for="search">recherche : </label>
    <input type="search" id="search" name="search_word"><br><br>
    <label for="site"> site</label>
    <input type="radio" id="site" name="search_object" value="site"><br><br>
    <label for="topo"> topo</label>
    <input type="radio" id="topo" name="search_object" value="topo"><br><br>
    <label for="user"> user</label>
    <input type="radio" id="user" name="search_object" value="user"><br><br>

    <input type="Submit" value="Ok"/>

</form>
</div>
</div>
</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>



