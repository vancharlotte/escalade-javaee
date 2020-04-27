<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="blog-header">

    <div class="title">
        <div class="element2a">
            <sec:authorize access="isAnonymous()">
                <a href="${pageContext.request.contextPath}/login"> Se connecter</a>
                <a href="${pageContext.request.contextPath}/register"> S'inscrire</a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <a href="${pageContext.request.contextPath}/logout"> Se déconnecter</a>
                <a href="${pageContext.request.contextPath}//page?userId=<c:out value="${user.userId}"/>'"> Mon
                    profil</a>
            </sec:authorize>
        </div>

        <div class="element1">
            <a href="${pageContext.request.contextPath}/welcome"><h1>Le blog des grimpeurs</h1></a>
        </div>

        <div class="element2b">

            <a href="${pageContext.request.contextPath}/listSite?page=1">Sites d'escalade</a>

        </div>

    </div>

    <div class="element3">
        <form action="search" method="post" accept-charset="ISO-8859-1">
            <input type="radio" id="site" name="search_object" value="site" checked>
            <label for="site"> site</label>
            <input type="radio" id="topo" name="search_object" value="topo">
            <label for="topo"> topo</label>
            <input type="radio" id="user" name="search_object" value="user">
            <label for="user"> user</label>
            <input type="search" id="search" name="search_word">
            <label for="search"> </label>
            <input type="Submit" value="Ok"/>
        </form>
    </div>

</div>
