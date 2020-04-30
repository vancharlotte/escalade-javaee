Projet 6 - Créez un site communautaire autour de l’escalade

Un site web où l'on peut consulter la description de des sites d'escalade et une liste de topos disponibles à la réservation.

Java jdk 8
Apache Maven
Apache Tomcat
PostgreSQL

Déploiement: 

Créer une base de donnée Postgresql appelée : db_escalade 
datasource URL: jdbc:postgresql://localhost:5432/db_escalade
owner ID: admin - password: admin123
Se rendre dans le répertoire: escalade-javaee/src/resources/db-escalade
Utilisez le fichier createdb.sql pour créer les tables de votre BDD
et le fichier inserdb.sql pour insérer un jeu de données de démo.

Se rendre dans le répertoire: escalade-javaee/war
Copiez le fichier "Escalade.war" et collez le dans le dossier "webapps" de votre installation Tomcat
En invite de commande rendez vous dans votre dossier Tomcat/bin et exécutez startup.bat
Dans votre navigateur, allez sur : "http://localhost:8080/Escalade"

Plusieurs comptes utilisateur sont déjà créés dans la base de données : 
- compte Admin 
id : user1 / pwd: 1ABCDefgh
- compte User
id : user2 / pwd: 1ABCDefgh
id : user3 / pwd: 1ABCDefgh


