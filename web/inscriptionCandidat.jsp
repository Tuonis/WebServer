<%-- 
    Document   : saisieCandidature
    Created on : 24 mai 2013, 13:16:34
    Author     : Chanthavone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisie Candidature</title>
    </head>
    <body>
        <h1>Saisie candidature</h1>
        <form action="TestServlet" method="post">
            Nom : <input type="text" name="nom"/> <br/>
            Prénom : <input type="text" name="prenom"/> <br/>
            Téléphone : <input type="text" name="telephone"/> <br/>
            Email : <input type="text" name="mail"/> <br/>
            Adresse : <input type="text" name="adresse"/> <br/>
            Diplomes : <input type="text" name="diplome"/> <br/>
            Compétences : <input type="text" name="competence"/> <br/>
            Situation professionnelle : <input type="text" name="situationPro"/> <br/>
            <input type="hidden"  name="choix"  value="6">
            <input type="submit" name="inscrire" value="valider"/>
        </form>
    </body>
</html>
