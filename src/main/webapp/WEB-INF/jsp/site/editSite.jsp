<head>
    <title> modifier site </title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
</head>

<body>


<form method="post" action="editSite">

    <table>
        <tr>
            <td><label for="siteId"></label></td>
            <td><input type="hidden" name="siteId" id="siteId" value="${site.siteId}"/></td>
        </tr>
        <tr>
            <td><label for="name">Nom : </label></td>
            <td><input type="text" name="name" id="name" value="${site.name}"/></td>
        </tr>
        <tr>
            <td><label for="city">Ville  : </label></td>
            <td><input type="text" name="city" id="city" value="${site.city}"/></td>
        </tr>
        <tr>
            <td><label>Departement : </label></td>
            <td><select name="departement" >
                <option value="${site.departement}"selected hidden>${site.departement}</option>
                <c:forEach var="departement" items="${departementList}">
                    <option value="${departement}">${departement}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><label>Cotation Minimale : </label></td>
            <td><select name="quotationMin">
                <option value="${site.quotationMin}"selected hidden>${site.quotationMin}</option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td><label>Cotation Maximale : </label></td>
            <td><select name="quotationMax">
                <option value="${site.quotationMax}"selected hidden>${site.quotationMax}</option>
                <c:forEach var="quotation" items="${quotationList}">
                    <option value="${quotation}">${quotation}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><label for="nbRoutes"> Nombre de voies : </label></td>
            <td><input type="text" name="nbRoutes" id="nbRoutes" value="${site.nbRoutes}"/></td>
        </tr>
        <tr>
            <td><label for="description">Description : </label></td>
            <td><textarea rows="5" cols="50" name="description" id="description" value="${site.description}"></textarea>
            </td>
        </tr>
        <tr>
            <td> Amis de l'escalade :</td>
            <td><input type="radio" name="ckecked" id="true" value="true"/>
                <label for="true">Yes</label>
                <input type="radio" name="checked" id="false" value="false" checked/>
                <label for="false">No</label>
            </td>

        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>


</body>

</html>



