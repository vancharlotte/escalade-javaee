<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Accueil</title>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <style>
        <%@include file="/WEB-INF/fragments/style.css"%>

        .blog-description {
            font-size: 1.1em;
        }

    </style>


</head>


<body>


<div class="blog-description">
    <h2> Bienvenue</h2>

    <hr>

    <div>

        <p>Pour les non-initiés, voici quelques éléments du vocabulaire du grimpeur :
        <ul>
            <li>Un site ou spot, c’est un lieu où il est possible de grimper.</li>
            <li>Les sites peuvent être découpés en plusieurs secteurs qui regroupent un ensemble de voies.</li>
            <li>« Lao Tzeu l'a dit : il faut trouver la voie » : c’est le chemin à emprunter par le grimpeur pour
                arriver à
                destination : le haut de la voie.
            </li>
            <li>si la voie est découpée en plusieurs « parties » à grimper les unes après les autres, ces parties
                s’appellent des longueurs et on trouve un relai en haut de chaque longueur.
            </li>
            <li>Quand le grimpeur arrive en haut de la longueur, c’est à ce relai qu’il se vache, c’est à dire qu’il s’y
                accroche, à l’aide de sa vache ou longe (corde nouée sur le baudrier du grimpeur et équipée d’un
                mousqueton
                à verrouillage).
            </li>
            <li>Les points ou spits sont des ancrages fixes que l’on trouve dans les voies dites « équipées » et qui
                permettent au grimpeur de s’assurer au fur et à mesure de sa progression, à l’aide de dégaines
            </li>
            <li>La cotation d’une longueur ou d’une voie, représente sa difficulté. En France, le système de cotation
                va, en
                gros, par ordre croissant de difficulté, de 3 à 9c. Le chiffre est en quelque sorte, l’unité principale
                et
                la lettre une sous-unité (de « a » à « c »)
            </li>
            <li>Un topo est un recueil contenant toutes les informations utiles sur les sites d’escalade d’une région
                (les
                secteurs, les voies, leur hauteur, leur cotation, le nombre de points…). Une bible quoi !
            </li>
        </ul>
        </p>
    </div>
    <hr>
    <div>
        <h4>Une envie de vacances ?</h4>
        <p>Pourquoi ne pas partir sur l’Île de la Réunion ?<br/>
            Cet endroit paradisiaque est également propice à l’escalade !
            Les fans de blocs seront ravis des nombreux spots qu’offrent l’île et pour les autres… ce sera l’occasion de
            découvrir ce type d’escalade ;).
            Notez justement qu’il existe des voies pour tous les niveaux, que vous soyez débutants ou confirmés.
        </p>
    </div>
</div>


</body>

<footer>
    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</footer>
</html>

