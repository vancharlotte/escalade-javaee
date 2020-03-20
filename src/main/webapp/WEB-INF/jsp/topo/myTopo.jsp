<%--
  Created by IntelliJ IDEA.
  User: vanhu
  Date: 16/03/2020
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
<a href="${pageContext.request.contextPath}/addTopo"> Ajouter un topo  </a>
<br>


<h2> Mes topos : </h2>

<c:if test="${not empty list}">

    <c:forEach var="topo" items="${list}">


        <li><c:out value="${topo.name}"/>

            <a href="${pageContext.request.contextPath}/editTopo?<c:out value="${topo.topoId}"/>"> Modifier  </a>
            <a href="${pageContext.request.contextPath}/deleteTopo"> Supprimer  </a>
            <a href="${pageContext.request.contextPath}/editStatus"> Modifier Statut  </a>




        </li>
    </c:forEach>

</c:if>




</body>
</html>
