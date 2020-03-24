<%--
  Created by IntelliJ IDEA.
  User: vanhu
  Date: 24/03/2020
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .header {
        background-color: powderblue;
        border: 1px solid powderblue;
        color: royalblue;
    }
    .error {
        color: red;
    }
</style>
<div class=header style="text-align:left">
    <button style="color: royalblue" onclick="window.location.href='${pageContext.request.contextPath}/login'"> Se
        connecter
    </button>
    <button style="color: royalblue" onclick="window.location.href='${pageContext.request.contextPath}/register'">
        S'inscrire
    </button>
</div>
<div class=header style="text-align:right">
    <form action="search" method="post">
        <input type="radio" id="site" name="search_object" value="site" checked>
        <label for="site"> site</label>
        <input type="radio" id="topo" name="search_object" value="topo">
        <label for="topo"> topo</label>
        <input type="radio" id="user" name="search_object" value="user">
        <label for="user"> user</label>
        <input type="search" id="search" name="search_word">
        <label for="search"> </label>
        <input style="color: royalblue" type="Submit" value="Ok"/>
    </form>
</div>

