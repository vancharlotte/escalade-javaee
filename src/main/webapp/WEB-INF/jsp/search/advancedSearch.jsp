<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> recherche </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>

<h2>Recherche</h2>

<form action="search" method="post">

    <input type="search" id="search" name="search_word" value="search">
    <label for="search">recherche : </label><br>
    <input type="radio" id="site" name="search_object" value="site">
    <label for="site"> site</label><br>
    <input type="radio" id="topo" name="search_object" value="topo">
    <label for="topo"> topo</label><br>
    <input type="radio" id="user" name="search_object" value="user">
    <label for="user"> user</label>

    <input type="Submit" value="Ok"/>

</form>

</body>
</html>



