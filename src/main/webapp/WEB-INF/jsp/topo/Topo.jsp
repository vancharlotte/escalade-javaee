<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Topo</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        .bordure {
            border: solid 1px blueviolet;
            padding: 25px;
            border-radius: 5px;
        }
    </style>
</head>

<body>
<br>
<h2>${topo.name}</h2>
<div style="overflow-x:auto;">

    <table>
        <tr>
            <td>
                par : ${owner.username}
                <br/> <br/>
                Où? ${topo.city}, ${topo.departement}
                <br/>
                date de parution : ${topo.releaseDate}
                <br/> <br/>
            </td>
        </tr>
        <tr>
            <td style="color: blueviolet">
                ${message}
                    <br/> <br/>
            </td>
        </tr>
        <tr>
            <td class=bordure>

                ${topo.description}
                    <br/> <br/>
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${(topo.available=true) && (user.username ne owner.username)}">
                    Voulez-vous réserver ce topo?
                    <a href="${pageContext.request.contextPath}/booking?<c:out value="${topo.topoId}"/>"> Réserver </a>
                </c:if>
            </td>
        </tr>

    </table>
</div>

</body>
</html>
