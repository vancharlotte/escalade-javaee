<%--
  Created by IntelliJ IDEA.
  User: vanhu
  Date: 16/03/2020
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <title>MY TOPO</title>
    <style>
        .button{
            color: cornflowerblue;
        }

        .button1{
            background-color: cornflowerblue;
            color: white;
        }
    </style>
</head>
<body>

<spring:url value="/user/addTopo" var="addTopoUrl"/>
<button class="button" onclick="location.href='${addTopoUrl}'">Ajouter un topo</button>
<br>


<h2> Mes topos : </h2>

<c:if test="${not empty topoList}">

    <c:forEach var="topo" items="${topoList}">


        <li><c:out value="${topo.name}"/>

            <spring:url value="/user/editTopo/${topo.topoId}" var="editTopoUrl"/>
            <spring:url value="/user/deleteTopo/${topo.topoId}" var="deleteTopoUrl"/>
            <spring:url value="/user/editStatus/${topo.topoId}" var="editStatusTopoUrl"/>

            <button class="button1" onclick="location.href='${editTopoUrl}'">Modifier</button>
            <button class="button1" onclick="location.href='${deleteTopoUrl}'"> Supprimer</button>
            <button class="button1" onclick="location.href='${editStatusTopoUrl}'"> Modifier Statut</button>

        </li>
    </c:forEach>

</c:if>




</body>
</html>
