<head>
    <title> ajouter site </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
        <%@include file="/WEB-INF/css/loginstyle.css" %>

    </style>
</head>

<body>

<div class="container">
    <div class="form">

        <h1>Ajouter un site d'escalade</h1>


        <form method="post" action="addSite">


            <label for="name">Nom : </label>
            <input type="text" name="name" id="name" />

            <label for="city">Ville : </label>
            <input type="text" name="city" id="city"/>

            <label>Departement : </label>
            <select name="departement">
                <option value="${site.departement}"></option>
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select>

            <label>Cotation Minimale : </label>
            <select name="quotationMin">
                <option value="${site.quotationMin}"></option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select>

            <label>Cotation Maximale : </label>
            <select name="quotationMax">
                <option value="${site.quotationMax}"></option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select>

            <label for="nbRoutes"> Nombre de voies : </label>
            <input type="text" name="nbRoutes" id="nbRoutes"/>

            <label for="description">Description : </label>
            <textarea rows="5" cols="50" name="description" id="description"></textarea>


            Amis de l'escalade :

            <input type="radio" name="checked" id="true" value="true" checked/>
            <label for="true">Yes</label>
            <input type="radio" name="checked" id="false" value="false"/>
            <label for="false">No</label>

            <input type="submit" value="Submit"/>

        </form>
    </div>
</div>


</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>



