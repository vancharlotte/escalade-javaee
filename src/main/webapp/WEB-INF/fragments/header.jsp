<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="blog-header">
    <div class="element1" style="text-align:left">

        <sec:authorize access="isAnonymous()">

            <button  onclick="window.location.href='${pageContext.request.contextPath}/login'">
                Se connecter
            </button>
            <br>
            <button
                    onclick="window.location.href='${pageContext.request.contextPath}/register'">
                S'inscrire
            </button>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">

            <button  onclick="window.location.href='${pageContext.request.contextPath}/logout'">
                Se déconnecter
            </button>
            <br>
            <button
                    onclick="window.location.href='${pageContext.request.contextPath}/page?<c:out
                            value="${user.userId}"/>'">
                Mon profil
            </button>
        </sec:authorize>
        <br>
        <button
                onclick="window.location.href='${pageContext.request.contextPath}/welcome<c:out
                        value="${user.userId}"/>'">
            Accueil
        </button>
    </div>

    <div class="element2" style="text-align:center">
        <h1>Le blog des grimpeurs</h1>
    </div>

    <div class="element3" style="text-align:right">
        <form action="search" method="post">
            <input type="radio" id="site" name="search_object" value="site" checked>
            <label for="site"> site</label>
            <input type="radio" id="topo" name="search_object" value="topo">
            <label for="topo"> topo</label>
            <input type="radio" id="user" name="search_object" value="user">
            <label for="user"> user</label>
            <br>
            <input type="search" id="search" name="search_word">
            <label for="search"> </label>
            <input type="Submit" value="Ok"/>
        </form>
    </div>
</div>

