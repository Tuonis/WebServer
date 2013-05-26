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
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisie Candidat</title>
    </head>
    <body>        
        <form action="ServletInscriptionCandidat" method="post">
            <h1>Saisie candidat</h1>
            <p> <label> Nom : </label> <input type="text" name="nom"/> </p>
            <p> <label> Prénom : </label> <input type="text" name="prenom"/> </p>
            <p> <label> Téléphone : </label> <input type="text" name="telephone"/> </p>
            <p> <label> Email : </label> <input type="text" name="mail"/> </p>
            <p> <label> Adresse : </label> <input type="text" name="adresse"/> </p>
            <p> <label> Diplomes : </label> <input type="text" name="diplome"/> </p>
            <p> <label> Compétences : </label> <input type="text" name="competence"/> </p>
            <p> <label> Situation professionnelle : </label> <input type="text" name="situationPro"/> </p>
            <input type="hidden"  name="choix"  value="6">
            <input type="submit" name="inscrire" value="valider"/>
        </form>
    </body>
</html>
