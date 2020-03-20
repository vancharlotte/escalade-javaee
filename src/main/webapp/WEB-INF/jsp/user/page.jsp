<%--
  Created by IntelliJ IDEA.
  User: vanhu
  Date: 15/03/2020
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>profil</title>
</head>
<body>
<h2> Page de profil</h2>

<table>
    <tr>
        <td>${message}</td>

    </tr>

</table>


<a href="${pageContext.request.contextPath}/user/myTopo"> Mes topos  </a>
<a href="${pageContext.request.contextPath}/user/myTopo"> Mes réservations  </a>


</body>
</html>
